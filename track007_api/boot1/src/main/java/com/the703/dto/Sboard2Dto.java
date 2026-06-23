package com.the703.dto;
 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sboard2Dto {
    private int id;               // ID
    private int appUserId;        // APP_USER_ID
    private String btitle;        // BTITLE
    private String bcontent;      // BCONTENT
    private String bpass;         // BPASS
    private String bfile;         // BFILE (default: 'no.png')
    private int bhit;             // BHIT (default: 0)
    private String bip;           // BIP
	private String createdAt;
}
