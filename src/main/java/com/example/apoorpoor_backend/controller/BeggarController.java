package com.example.apoorpoor_backend.controller;

import com.example.apoorpoor_backend.dto.beggar.*;
import com.example.apoorpoor_backend.dto.common.StatusResponseDto;
import com.example.apoorpoor_backend.security.UserDetailsImpl;
import com.example.apoorpoor_backend.service.BeggarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "BeggarController", description = "거지 캐릭터 controller")
@RestController
@RequiredArgsConstructor
public class BeggarController {

    private final BeggarService beggarService;

    @Operation(summary = "거지 캐릭터 생성 API", description = "거지 캐릭터 생성")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "거지 캐릭터 생성 완료")})
    @PostMapping("/beggar")
    public ResponseEntity<StatusResponseDto> createBeggar(@Valid @RequestBody BeggarRequestDto beggarRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return beggarService.createBeggar(beggarRequestDto, userDetails.getUsername());
    }

    @Operation(summary = "마이 거지 캐릭터 API", description = "내 거지 캐릭터 검색")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "거지 캐릭터 검색 완료")})
    @GetMapping("/beggar/{userId}")
    public ResponseEntity<BeggarSearchResponseDto> getUserBeggar(@PathVariable Long userId) {
        return beggarService.getUserBeggar(userId);
    }

    @Operation(summary = "마이 거지 캐릭터 닉테임 체크 API", description = "내 거지 캐릭터 닉네임 체크(중복, 욕설, 음란단어 체크)")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "거지 캐릭터 닉네임 체크 완료")})
    @GetMapping("/beggar/check/{nickname}")
    public ResponseEntity<String> nicknameCheck(@PathVariable String nickname) {
        return beggarService.nicknameCheck(nickname);
    }

    @Operation(summary = "거지 캐릭터 업데이트 API", description = "거지 캐릭터 update")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "거지 캐릭터 수정 완료")})
    @PatchMapping("/beggar")
    public ResponseEntity<StatusResponseDto> updateBeggar(@Valid @RequestBody BeggarRequestDto beggarRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return beggarService.updateBeggar(beggarRequestDto, userDetails.getUsername());
    }

    @Operation(summary = "거지 캐릭터 커스텀 API", description = "거지캐릭터에게 구매한 옷 입히기")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "옷 입히기 완료")})
    @PatchMapping("/beggar/custom")
    public ResponseEntity<String> customBeggar(@RequestBody BeggarCustomRequestDto beggarCustomRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return beggarService.customBeggar(beggarCustomRequestDto, userDetails.getUsername());
    }

    @Operation(summary = "거지 캐릭터 커스텀 조회 API", description = "거지캐릭터가 구매한 아이템 조회")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "조회 완료")})
    @GetMapping("/beggar/custom")
    public ResponseEntity<BeggarCustomListResponseDto> customList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return beggarService.customList(userDetails.getUsername());
    }

    @GetMapping("/beggar/info")
    public ResponseEntity<List<BeggarInfoDto>> getBeggarInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return beggarService.getBeggarInfo(userDetails.getUsername());
    }
}