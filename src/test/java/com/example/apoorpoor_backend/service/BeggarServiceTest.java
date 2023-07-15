package com.example.apoorpoor_backend.service;

import com.example.apoorpoor_backend.dto.beggar.BeggarRequestDto;
import com.example.apoorpoor_backend.dto.beggar.BeggarSearchResponseDto;
import com.example.apoorpoor_backend.dto.common.StatusResponseDto;
import com.example.apoorpoor_backend.model.Beggar;
import com.example.apoorpoor_backend.model.User;
import com.example.apoorpoor_backend.repository.beggar.BeggarRepository;

import com.example.apoorpoor_backend.repository.user.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;

import static com.example.apoorpoor_backend.model.enumType.UserRoleEnum.USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class BeggarServiceTest {

    @Autowired
    private BeggarRepository beggarRepository;

    @Autowired
    private BeggarService beggarService;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void createUser() {
        user = new User("user1", "qw!@zzx", USER, 10000L, "kakao_user");
        user.updateAge(30L);
        user.updateGender("male");
        userRepository.save(user);
    }

    @AfterEach
    public void deleteUser() {
        beggarRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("poor 캐릭터를 생성한다.")
    public void createBeggar() {
        // given
        BeggarRequestDto beggarRequestDto = new BeggarRequestDto("그지");

        // when
        ResponseEntity<StatusResponseDto> response = beggarService.createBeggar(beggarRequestDto, user.getUsername());

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(response.getBody()).getMessage()).isEqualTo("푸어가 생성되었어요...");

    }

    @Test
    @DisplayName("사회적으로 부적절한 단어로 닉네임을 생성하면 IllegalArgumentException 예외가 발생한다.")
    public void createByBadWordNickname() {
        // given
        BeggarRequestDto beggarRequestDto = new BeggarRequestDto("씨발");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            beggarService.createBeggar(beggarRequestDto, user.getUsername());
        });

    }

    @Test
    @DisplayName("이미 beggar를 만든 이용자는 BAD_REQUEST가 발생한다.")
    public void createByDuplicatedNickname() {
        // given
        Beggar beggar = Beggar.builder().nickname("그지")
                .user(user).point(0L).level(1L).exp(0L)
                .build();

        beggarRepository.save(beggar);

        BeggarRequestDto beggarRequestDto = new BeggarRequestDto("새그지");

        // when
        ResponseEntity<StatusResponseDto> response = beggarService.createBeggar(beggarRequestDto, user.getUsername());

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(Objects.requireNonNull(response.getBody()).getMessage()).isEqualTo("이미 푸어가 존재합니다.");

    }

    @Test
    @DisplayName("내 캐릭터 정보를 조회 한다.(description과 착용중인 아이템은 없다.)")
    public void myBeggar() {
        // given
        Beggar beggar = Beggar.builder().nickname("그지")
                .user(user).point(0L).level(1L).exp(0L)
                .build();

        beggarRepository.save(beggar);

        // when
        ResponseEntity<BeggarSearchResponseDto> response = beggarService.myBeggar(user.getUsername());

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting("beggarId", "userId", "nickname", "point",
                "level", "badgeList", "description", "gender", "age", "topImage", "bottomImage",
                "shoesImage", "accImage", "customImage")
                .contains(beggar.getId(), user.getId(), "그지", 0L,
                        1L, beggar.getGetBadgeList(), null, "male", 30L, null, null,
                        null, null, null);

    }

}