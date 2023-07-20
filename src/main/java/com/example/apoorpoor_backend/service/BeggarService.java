package com.example.apoorpoor_backend.service;

import com.example.apoorpoor_backend.dto.beggar.*;
import com.example.apoorpoor_backend.dto.chat.BadWordFiltering;
import com.example.apoorpoor_backend.dto.common.StatusResponseDto;
import com.example.apoorpoor_backend.model.*;
import com.example.apoorpoor_backend.model.enumType.*;
import com.example.apoorpoor_backend.repository.badge.BadgeRepository;
import com.example.apoorpoor_backend.repository.badge.GetBadgeRepository;
import com.example.apoorpoor_backend.repository.beggar.BeggarRepository;
import com.example.apoorpoor_backend.repository.ledgerhistory.LedgerHistoryRepository;
import com.example.apoorpoor_backend.repository.shop.ItemRepository;
import com.example.apoorpoor_backend.repository.shop.PointRepository;
import com.example.apoorpoor_backend.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class BeggarService {
    @Value("${secret.url.item}")
    private String itemUrl;
    @Value("${secret.url.badge}")
    private String badgeUrl;
    private final BeggarRepository beggarRepository;
    private final UserRepository userRepository;
    private final GetBadgeRepository getBadgeRepository;
    private final BadgeRepository badgeRepository;
    private final ItemRepository itemRepository;
    private final LedgerHistoryRepository ledgerHistoryRepository;
    private final PointRepository pointRepository;
    private final NotificationService notificationService;
    private final BadWordFiltering badWordFiltering;

    public ResponseEntity<StatusResponseDto> createBeggar(BeggarRequestDto beggarRequestDto, String username) {
        User findUser = userCheck(username);
        boolean badWordCheck = badIdCheck(beggarRequestDto.getNickname());

        if(badWordCheck) throw new IllegalArgumentException("사회적으로 부적절한 언어가 포함되어 있습니다.");

        Optional<Beggar> findBeggar = beggarRepository.findByUsername(username);
        if(findBeggar.isPresent())
            return new ResponseEntity<>(new StatusResponseDto("이미 푸어가 존재합니다."), HttpStatus.BAD_REQUEST);

        Beggar beggar = Beggar.builder()
                .nickname(beggarRequestDto.getNickname())
                .user(findUser)
                .point(0L)
                .level(1L)
                .exp(0L)
                .build();

        beggarRepository.save(beggar);

        return new ResponseEntity<>(new StatusResponseDto("푸어가 생성되었어요..."), HttpStatus.OK );
    }

    @Transactional(readOnly = true)
    public ResponseEntity<BeggarSearchResponseDto> myBeggar(String username) {
        User user = userCheck(username);
        boolean beggarCheck = beggarRepository.existsBeggarByUserId(user.getId());

        if(!beggarCheck) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Beggar beggar = beggarCheck(username);

        Long beggarId = beggar.getId();
        Long userId = user.getId();
        String nickname = beggar.getNickname();
        Long point = beggar.getPoint();
        Long level = beggar.getLevel();
        String description = beggar.getDescription();
        String gender = user.getGender();
        Long age = user.getAge();
        Long exp = beggar.getExp();
        List<Badge> badgeList = getBadgeList(beggarId);

        String topImage = beggar.getTop() == null ? null : itemUrl + beggar.getTop().getItemImage();
        String bottomImage = beggar.getBottom() == null ? null : itemUrl  + beggar.getBottom().getItemImage();
        String shoesImage = beggar.getShoes() == null ? null : itemUrl  + beggar.getShoes().getItemImage();
        String accImage = beggar.getAcc() == null ? null : itemUrl  + beggar.getAcc().getItemImage();
        String customImage = beggar.getCustom() == null ? null : itemUrl + beggar.getCustom().getItemImage();

        BeggarSearchResponseDto beggarSearchResponseDto = BeggarSearchResponseDto
                .builder().beggarId(beggarId)
                .userId(userId).nickname(nickname)
                .point(point).level(level)
                .exp(exp)
                .badgeList(badgeList)
                .description(description).gender(gender)
                .age(age).topImage(topImage).bottomImage(bottomImage)
                .shoesImage(shoesImage).accImage(accImage)
                .customImage(customImage)
                .build();

        return new ResponseEntity<>(beggarSearchResponseDto, HttpStatus.OK);
    }


    public List<Badge> getBadgeList(Long beggarId) {
        return badgeRepository.findByBadgeList(beggarId);
    }

    public ResponseEntity<BeggarSearchResponseDto> getUserBeggar(Long user_id) {
        User user = userIdCheck(user_id);
        Beggar beggar = beggarIdCheck(user_id);

        Long beggarId = beggar.getId();
        Long userId = user.getId();
        String nickname = beggar.getNickname();
        Long point = beggar.getPoint();
        Long level = beggar.getLevel();
        String description = beggar.getDescription();
        String gender = user.getGender();
        Long age = user.getAge();
        List<Badge> badgeList = getBadgeList(beggarId);

        String topImage = beggar.getTop() == null ? null : beggar.getTop().getItemImage();
        String bottomImage = beggar.getBottom() == null ? null : beggar.getBottom().getItemImage();
        String shoesImage = beggar.getShoes() == null ? null : beggar.getShoes().getItemImage();
        String accImage = beggar.getAcc() == null ? null : beggar.getAcc().getItemImage();
        String customImage = beggar.getCustom() == null ? null : beggar.getCustom().getItemImage();



        BeggarSearchResponseDto beggarSearchResponseDto = BeggarSearchResponseDto
                .builder().beggarId(beggarId)
                .userId(userId).nickname(nickname)
                .point(point).level(level)
                .badgeList(badgeList)
                .description(description).gender(gender)
                .age(age).topImage(topImage).bottomImage(bottomImage)
                .shoesImage(shoesImage).accImage(accImage)
                .customImage(customImage)
                .build();


        return new ResponseEntity<>(beggarSearchResponseDto, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<String> nicknameCheck(String nickname) {

        boolean badWordCheck = badIdCheck(nickname);

        if(badWordCheck) {
            return new ResponseEntity<>("사회적으로 부적절한 언어가 포함되어 있습니다.", HttpStatus.FORBIDDEN);
        }

        boolean duplicateCheck = beggarRepository.existsBeggarByNickname(nickname);

        if(duplicateCheck) {
            return new ResponseEntity<>("이미 존재 하는 아이디 입니다.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("사용 가능한 아이디 입니다.", HttpStatus.OK);
    }


    public ResponseEntity<StatusResponseDto> updateBeggar(BeggarRequestDto beggarRequestDto, String username) {
        Beggar beggar = beggarCheck(username);
        badIdCheck(beggarRequestDto.getNickname());

        Optional<Beggar> findBeggar = beggarRepository.findByNickname(beggarRequestDto.getNickname());
        if(findBeggar.isPresent())
            return new ResponseEntity<>(new StatusResponseDto("중복된 푸어의 이름이 존재합니다."), HttpStatus.BAD_REQUEST);

        beggar.update(beggarRequestDto);

        return new ResponseEntity<>(new StatusResponseDto("닉네임 변경 완료"), HttpStatus.OK);
    }


    public void updateExpNew(String username, ExpType expType) {
        Beggar beggar = beggarCheck(username);

        Long plusPoint = expType.getAmount();

        beggar.updatePointAndExp(plusPoint);

        String pointDescription = expType.getDescription();

        if(expType.equals(ExpType.BEST_SAVER)) {
            pointDescription = ExpType.BEST_SAVER.getDescription();
        }

        if(expType.equals(ExpType.LEVEL_UP)) {
            pointDescription = ExpType.LEVEL_UP.getDescription();
        }

        Point recordPoint = Point.builder()
                .pointDescription(pointDescription)
                .earnedPoint(plusPoint)
                .usedPoints(null)
                .beggar(beggar)
                .build();

        pointRepository.save(recordPoint);

        Long exp = beggar.getExp();
        Long level = beggar.getLevel();

        if (LevelType.getNextExpByLevel(level) <= exp) {
            level++;
            beggar.updateLevel(level);
            updateExpNew(username, ExpType.LEVEL_UP);
            notificationService.notifyLevelUpEvent(username, beggar);
        }
    }

    public void badgeCheck(User user) {
        Beggar beggar = beggarCheck(user.getUsername());
        List<ExpenditureType> badgeList = Arrays.asList(ExpenditureType.values());

        for (ExpenditureType expenditureType : badgeList) {
            if(badgeCriteriaCheck(expenditureType, user.getId())) saveBadgeNew(user, expenditureType, beggar);
        }

    }

    private boolean badgeCriteriaCheck(ExpenditureType expenditureType, Long userId) {
        return switch (expenditureType){
            case UTILITY_BILL -> false;
            case CONDOLENCE_EXPENSE -> ledgerHistoryRepository.checkEXPType2(expenditureType, userId);
            case TRANSPORTATION -> ledgerHistoryRepository.checkEXPType3(expenditureType, userId);
            case COMMUNICATION_EXPENSES -> ledgerHistoryRepository.checkEXPType4(expenditureType, userId);
            case INSURANCE -> ledgerHistoryRepository.checkEXPType5(expenditureType, userId);
            case EDUCATION -> false;
            case SAVINGS -> ledgerHistoryRepository.checkEXPType7(expenditureType, userId);
            case CULTURE -> ledgerHistoryRepository.checkEXPType8(expenditureType, userId);
            case HEALTH -> ledgerHistoryRepository.checkEXPType9(expenditureType, userId);
            case FOOD_EXPENSES -> ledgerHistoryRepository.checkEXPType10(expenditureType, userId);
            case SHOPPING -> ledgerHistoryRepository.checkEXPType11(expenditureType, userId);
            case LEISURE_ACTIVITIES -> ledgerHistoryRepository.checkEXPType12(expenditureType, userId);
            case OTHER -> false;
        };
    }

    public void addPoints(User user) {
        Beggar beggar = beggarCheck(user.getUsername());
        long badgeCount = getBadgeRepository.countByBeggar(beggar.getId());
        long point = badgeCount * 20;
        beggar.updatePointAndExp(point);
    }


    public void saveBadgeNew(User user, ExpenditureType expenditureType, Beggar beggar) {
        Long badgeNum = expenditureType.getBadgeNum();
        String badgeTitle = expenditureType.getBadgeTitle();
        String badgeImage = badgeUrl + expenditureType.getBadgeImage();

        boolean hasBadge = beggar.getGetBadgeList().stream()
                .map(GetBadge::getBadge)
                .anyMatch(b -> b.getBadgeNum().equals(badgeNum));

        if(!hasBadge) {

            Badge badge = new Badge(badgeNum, badgeTitle, badgeImage);

            badgeRepository.save(badge);

            GetBadge getBadge = new GetBadge(badge, beggar);
            badge.getGetBadgeList().add(getBadge);
            getBadgeRepository.save(getBadge);

            updateExpNew(beggar.getUser().getUsername(), ExpType.GET_BADGE);

            notificationService.notifyGetBadgeEvent(user, expenditureType.getBadgeTitle());

        } else {
            throw new IllegalArgumentException("이미 뱃지를 가지고 있습니다.");
        }
    }


    public ResponseEntity<String> customBeggar(BeggarCustomRequestDto beggarCustomRequestDto, String username) {
        Beggar beggar = beggarCheck(username);
        ItemListEnum itemListEnum = beggarCustomRequestDto.getItemListEnum();
        UnWearEnum unWearEnum = beggarCustomRequestDto.getUnWearEnum();

        if(unWearEnum != null) {
            String unWear = unWearEnum.getUnWearPart();

            switch (unWear) {
                case "top" -> beggar.updateCustomTops(null);
                case "bottom" -> beggar.updateCustomBottoms(null);
                case "shoes" -> beggar.updateCustomShoes(null);
                case "acc" -> beggar.updateCustomAccessories(null);
                case "custom" -> beggar.updateCustoms(null);
                default -> throw new IllegalArgumentException("옳지 못한 행동입니다.");
            }
        } else {

            Item findItem = itemRepository.findItemByBeggar_IdAndItemNum(beggar.getId(),itemListEnum.getItemNum())
                    .orElseThrow(() -> new IllegalArgumentException("가지고 있지 않은 아이템 입니다.")
                    );

            String itemType = findItem.getItemType();

            switch (itemType) {
                case "top" -> beggar.updateCustomTops(itemListEnum);
                case "bottom" -> beggar.updateCustomBottoms(itemListEnum);
                case "shoes" -> beggar.updateCustomShoes(itemListEnum);
                case "acc" -> beggar.updateCustomAccessories(itemListEnum);
                case "custom" -> beggar.updateCustoms(itemListEnum);
                default -> throw new IllegalArgumentException("옳지 못한 행동입니다.");
            }
        }
        beggarRepository.save(beggar);
        return new ResponseEntity<>("착용 완료", HttpStatus.OK);
    }

    public ResponseEntity<BeggarCustomListResponseDto> customList(String username) {
        Beggar beggar = beggarCheck(username);
        List<Item> hasItemList = itemRepository.findItemsByBeggar_Id(beggar.getId());
        List<ItemDto> itemsCollectionList = new ArrayList<>();

        for (Item item : hasItemList) {
            Long itemNum = item.getItemNum();
            String itemName = item.getItemName();
            Long levelLimit = item.getLevelLimit();
            String itemType = item.getItemType();

            ItemDto itemDto = ItemDto.builder()
                    .itemNum(itemNum)
                    .itemName(itemName)
                    .levelLimit(levelLimit)
                    .itemType(itemType)
                    .build();

            itemsCollectionList.add(itemDto);

        }

        BeggarCustomListResponseDto beggarCustomListResponseDto = BeggarCustomListResponseDto.builder()
                .itemsCollectionList(itemsCollectionList)
                .build();

        return new ResponseEntity<>(beggarCustomListResponseDto, HttpStatus.OK);
    }

    public ResponseEntity<List<BeggarInfoDto>> getBeggarInfo(String username) {
        User user = userCheck(username);

        List<BeggarInfoDto> beggarInfoDtoList = new ArrayList<>();

        List<Beggar> beggarList = beggarRepository.findAll();
        for (Beggar beggar : beggarList) {
            BeggarInfoDto beggarInfoDto = BeggarInfoDto.builder()
                    .beggar_id(beggar.getId())
                    .nickname(beggar.getNickname())
                    .build();
            beggarInfoDtoList.add(beggarInfoDto);
        }
        return new ResponseEntity<>(beggarInfoDtoList, HttpStatus.OK);
    }

    public User userCheck(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저 입니다.")
        );
    }

    public Beggar beggarCheck(String username) {
        return beggarRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("푸어를 찾을 수 없습니다.")
        );
    }

    public User userIdCheck(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저 입니다.")
        );
    }

    public Beggar beggarIdCheck(Long userId) {
        return beggarRepository.findByUserId(userId).orElseThrow(
                () -> new IllegalArgumentException("푸어를 찾을 수 없습니다.")
        );
    }

    public void resetBadge() {
        getBadgeRepository.deleteAll();
    }

    public boolean badIdCheck(String nickname) {
        return badWordFiltering.checkBadId(nickname);
    }

    public void resetChallengeTitle(Beggar beggar) {
        beggar.resetChallenge();
    }

    public List<Beggar> getBeggarList() {
        return beggarRepository.findAll();
    }
}
