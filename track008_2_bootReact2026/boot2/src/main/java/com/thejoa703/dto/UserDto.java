package com.thejoa703.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto { 
    // 회원가입 요청 DTO
    @Getter @Setter
    public static class UserRequestDto {
        private String email;
        private String password;
        private String nickname;
        private String mobile;
        private Integer mbtitype;
    }

    // 회원 정보 응답 DTO
    @Getter
    public static class UserResponseDto {
        private Long   id;
        private String email;
        private String nickname;
        private String mobile;
        private Integer mbtitype;
        private String role;

        public UserResponseDto(com.thejoa703.entity.AppUser user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.nickname = user.getNickname();
            this.mobile = user.getMobile();
            this.mbtitype = user.getMbtitype();
            this.role = user.getRole();
        }
    }
}