# 🐳 어푸어푸 🐳

![브로슈어 썸네일](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/e17530f8-ebad-4a09-a278-a1f65e80d045)

## 🌊 배포 주소
https://www.apoorpoor.com

## 🌊 YouTube 시연 영상
[바로가기](https://youtu.be/KhixXeC0qq8)

## 🌊 프로젝트 개요

### 🐳 프로젝트명
나만의 거지 키우기 - 어푸어푸

### 🐳 프로젝트 한줄 소개
기본적인 가계부 기능에 나만의 거지 캐릭터인 푸어의 포인트를 모아 옷을 입혀 자랑하고, 다른 이용자들과 지출 내용에 대한 오픈 채팅이 가능한 서비스입니다

### 🐳 개발 기간
2023년 5월 19일 ~ 6월 23일 (35일)

### 🐳 팀원 소개
항해99 14기 스프링반
<table>
  <tbody>
    <tr>
      <td align="center"><a href="https://github.com/eivomin"><img src="https://avatars.githubusercontent.com/u/97949070?v=4" width="100px;" alt=""/><br /><sub><b>BE 리더 : 조유민</b></sub></a><br /></td>
      <td align="center"><a href="https://github.com/chaeeun0-o"><img src="https://avatars.githubusercontent.com/u/122453216?v=4" width="100px;" alt=""/><br /><sub><b>BE 팀원 : 김채은</b></sub></a><br /></td>
      <td align="center"><a href="https://github.com/leesco22"><img src="https://avatars.githubusercontent.com/u/127731995?v=4" width="100px;" alt=""/><br /><sub><b>BE 팀원 : 이세훈</b></sub></a><br /></td>
      <td align="center"><a href="https://github.com/OliveLover"><img src="https://avatars.githubusercontent.com/u/118647313?v=4" width="100px;" alt=""/><br /><sub><b>BE 팀원 : 이현규</b></sub></a><br /></td>
    </tr>
  </tbody>
</table>

## 🌊 서비스 아키텍쳐
<img width="1299" alt="image" src="https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/3e7682a1-791c-419c-9b74-76eaacf74220">

## 🌊 기술 스택 & 협업
**Back-End**
<div align="start">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=black">
  <img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white">
  <img src="https://img.shields.io/badge/websocket-010101?style=for-the-badge&logo=websocket&logoColor=white">
  <img src="https://img.shields.io/badge/AWS S3-569A31?style=for-the-badge&logo=AWS S3&logoColor=white">
  <img src="https://img.shields.io/badge/JSON WEB TOKENS-000000?style=for-the-badge&logo=JSON WEB TOKENS&logoColor=white">
  <img src="https://img.shields.io/badge/AWS EC2-FF920F?style=for-the-badge">
  <img src="https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=black">
  <img src="https://img.shields.io/badge/Github Actions-2088FF?style=for-the-badge&logo=Github Actions&logoColor=white">
  
</div>
<br/>

**Tools**
<div>
  <img src="https://img.shields.io/badge/GITHUB-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/NOTION-181717?style=for-the-badge&logo=notion&logoColor=white">
  <img src="https://img.shields.io/badge/SLACK-4A154B?style=for-the-badge&logo=slack&logoColor=white">
  <img src="https://img.shields.io/badge/googlesheets-34A853?style=for-the-badge&logo=googlesheets&logoColor=white">
  <img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">
</div>

## 🌊 기술적 의사결정

| 선택 기술 | 선택이유 및 근거 |
| --- | --- |
| SSE | 사용자가 현재 캐릭터의 상태와 이벤트로 인한 변화를 즉시 인지할 수 있도록 하고자 함. 포인트 획득, 레벨업, 챌린지 등의 불특정한 시간에 발생하는 이벤트에 대해 자동으로 알림을 전송하여 사용자에게 변화된 상태를 알려주는 방법이 필요했음. 이를 위해 Server-Sent Events (SSE)가 가장 적합한 기술이라고 판단하였음. |
| QueryDSL | 가계부 관련 필터링 쿼리가 여러 파라미터를 받아 복잡하고 동적인 쿼리를 작성해야 함, 컴파일 시점에 문법 오류를 확인할 수 있어 유동적인 쿼리 작성이 가능한 QueryDSL을 사용함 |
| Github Action | CI/CD에는 여러가지 툴이 있지만 다른 툴들에 비해 설정 프로세스가 매우 간단하고 public repo 를 사용할 시에 무료라는 점에 사용함 |
| Redis | 채팅 내역을 바로 데이터베이스에 저장하고 불러오는 것은 데이터베이스에 부하를 초래할 수 있어서, 캐싱을 사용하여 임시 저장 함으로써 데이터베이스의 부하를 줄이고 응답 시간을 개선하고 하였음. |
| Websocket | WebSocket은 데이터 송수신을 동시에 할 수 있는 양방향 통신관계이기 때문에 서버와 클라이언트 간의 실시간 업데이트를 해야 하는 채팅에 아주 적합함. |

## 🌊 서비스 핵심기능

💬 수입/지출을 그래프로 확인 할 수 있는 가계부 페이지

- 작성한 가계부 데이터를 캘린더에서 일일 `수입`, `지출` 합계 금액으로 확인 가능
  
- 이번달 카테고리별 지출 내역을 `파이그래프`로 확인 가능

- 지난달, 작년 동월, 작년 동분기 데이터를 올해 데이터와 비교해서 `막대그래프`로 확인 가능
  
  ![조회](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/7a80ab7c-6f12-4bb8-8311-91ed67535104)


💬 수입/지출을 등록 할 수 있는 가계부 등록 페이지
  
- 해당 날짜에 수입/지출 내역을 카테고리를 선택하여 등록 가능
  
![등록](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/27b2c09b-733f-4a35-840d-d0dd7a1fa234)


💬 나만의 푸어를 키우고 사용자의 푸어, 소비성향 등이 조회 가능한 마이 페이지

- 가계부 작성 등으로 얻은 포인트를 사용해서 `푸어아이템` 구매/착용 가능
  
- 카테고리별 기준을 충족하면 `푸어뱃지` 획득 가능
  
- 사용자의 소비데이터를 카테고리 그룹별로 수치화하여 직관적으로 볼 수 있는 `육각그래프`, `꺾은선그래프`로 확인 가능
  
- 사용자의 포인트 적립, 사용 내역을 기간별로 확인 가능

![마이페이지](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/efcb016d-c825-4888-a974-ca84c035ac43)


💬 나와 다른 사람들의 수입/지출 랭킹을 확인할 수 있는 랭킹 페이지

- 사용자와 같은 연령대, 성별을 가진 사용자들의 평균 수입, 지출 내역으로 순위 확인 가능

![랭킹2](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/ca29ea8c-27c4-44c9-94a0-623180c4b739)


  
💬 다른 유저들과 채팅을 할 수 있는 오픈채팅 푸어톡 페이지

- 카X오톡 거지방처럼 다양한 사용자들끼리 채팅 가능
  
- 채팅에 참여한 참여자를 알 수 있음
  
- 채팅 내역과 채팅에 보낸 이미지를 확인할 수 있음
  
- 상대의 프로필을 눌러서 푸어 상태, 뱃지 확인 가능

![푸어톡](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/a4a4d415-0a28-4dd0-926e-6c9265c0c372)


💬 자신만의 싸움! 매주마다 참여하는 소비 / 무지출 챌린지 페이지

- 매주마다 2, 5, 10만원만 사용하는 지출 챌린지 가능
  
- 매주마다 무지출하는 챌린지 가능
  
- 챌린지 성공 시, 푸어 포인트 획득

![챌린지](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/55583cfc-a74a-44b1-9fcc-76b0f3c500f1)


## 🌊 트러블 슈팅
<details>
<summary>아이템 리스트를 호출 시 필터링</summary>
<div markdown="1">

`❗이슈 내용`

아이템 리스트를 호출할 때 구매하지않은 아이템, 구매한 아이템 , 장착한 아이템 호출을 한 번에 해야했음

`❓해결을 위한 시도`

Enum으로 저장한 아이템 리스트를 for문으로 전체를 나열한 뒤 구매한 아이템을 구분하기 위하여 for문으로 한 번더 검사를 하고  한 번 더 정착여부를 검사하기 위하여 반복문을 이용함.

하지만 3중 반복문은 처리성능이 현저히 느려짐

`🐳해결 방법`

3중 반복문을 쓰지 않기위해 미리 유저가 들고있는 아이템을 리스트로 만들어 모든 아이템 개수만큼 리스트로 만들어 표시 하고, 이 리스트를 전체 아이템 시트를 나열할 때 기본 값이 null 에서 "DONE"으로 바뀌도록 함

아이템 착용 여부는 각각의 착용 부위에 만큼 if문으로 걸러 최종적으로 for문을 중첩하지 않아 크게 성능 개선을 할  수 있었음

</div>
</details>
<details>
<summary>챌린지를 생성하고 이전에 챌린지가 있다면 수정하여 그대로 사용하기</summary>
<div markdown="1">

`❗이슈 내용`

비슷한 명령의 호출을 하나로 만듦으로써 중복된 코드를 제거하고 가독성이 증가하여 효율이 좋아질 것이라고 생각함

@Post요청으로 챌린지를 생성하고 이전에 챌린지를 생성한 적이 있다면 이전에 사용한 챌린지를 수정하여 사용하려고 함
하지만, 의도한대로 동작하지 않아 디버깅 하였더니 분명히 의도한대로 데이터는 잘들어가고 수정도 되었으나
마지막 출력시 데이터가 원상복구가 되어 최종적으로 변경이 되지 않는 현상이 발생

`❓해결을 위한 시도`

SRP(단일 책임원칙)을 최대한 지키고 싶었지만, 하나의 호출에 여러 명령을 수행할 필요가 있었음
따라서 각각의 한가지 기능만 하는 메서드를 나누어 분리하기로 하였고, 자칫하면 가독성을 해칠수도 있을까 염려하며 EventHandler를 통하여 이전 챌린지내역을 수정 하여 새로 저장하고자 하였음

새로운 챌린지 생성은 save로 처리하고, 이미 존재 한다면 EventHandler로서 해당 레코드값만 변경하면서  새로운 챌린지를 도전하는 것처럼 표현하고자 하였음

하지만 이 방법 역시 마지막은 데이터베이스의 변화가 발생하지 않음

`🐳해결 방법`

@Transactional 때문에 DB의 상태가 이전 상태를 기억하고 있다가 @Post요청시 save를 수행하면 이전 상태에서 INSERT가 되고 난 뒤 최종적으로 저장이 되어야 하는데,  수정이 이루어지므로 격리성(Isolation)의 원칙을 어기지 않았나 하는 가설을 세워 다른 방법을 생각함
Beggar의 엔티티에 참가 중인 Challenge가 없으면 null로 바꾸고 있으면 Challenge의 title이 들어가게 함으로서  Challenge 참가 및 종료 여부를 알 수 있게 함
Beggar의 챌린지 참석여부가 null과 아닐때로 구분하여 null이면 새로운 챌린지에 도전하도록 구현함

</div>
</details>

## 🌊 API 명세 / 와이어프레임

🐳[API명세서](https://docs.google.com/spreadsheets/d/1KdPC1GW8KxtWxX5jGaHe6r8tpokIT2xPr7AI5BdSE3M/edit#gid=0)

🐳[와이어프레임](https://www.figma.com/file/a4yKIz6LCPMPVbfaAmPgZg/%EC%96%B4%ED%91%B8%EC%96%B4%ED%91%B8?type=design&node-id=1-1560&mode=design&t=ZJtpxJrY7pYxlWpa-0)


## 🌊 ERD
![model](https://github.com/Apoorpoor/Apoorpoor_Backend/assets/97949070/5ddca576-c2b7-456e-a017-fb6972dc0f0d)

## 🌊 피드백 개선

### 💧사용법을 잘 모르겠어요

- 메인 화면을 갔을 때 튜토리얼 확인가능하게수정
  
- 랭킹과 포인트 부분에서도 툴팁을 통해 설명 추가



### 💧이전 채팅 내역이 안 보이는게 아쉽고 채팅방에 누가 있는지 알 수 있었으면 좋겠어요 

- 채팅방을 나갔다가 들어와도 이전 채팅 내역이 보여지게끔 수정
  
- 현재 채팅방에 누가 있는지 확인 가능하게 대화 상대 목록 추가
  


### 💧더 재밌는 챌린지 요소를 추가했으면 좋겠어요 

- MZ세대 중심으로 확산되는 무지출 챌린지 추가
  


