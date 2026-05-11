package com.the703.basic016;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaIO002_byte {
	public static void main(String[] args) {
		//#1. 경로  
		String folder_rel = "src/com/the703/basic016/";  // 상대경로- 현재작업 폴더기준
		String file_path  = "io002_byte.txt";
		
		File folder = new  File(folder_rel);
		File file   = new  File(folder_rel + file_path);
		
		//#2. 폴더 + 파일 ( exists, mkdirs , createNewFile)
		try {
			if(  !folder.exists()) {  folder.mkdirs(); }
			if(  !file.exists()  ) {  file.createNewFile(); }
		}catch(Exception e) { e.printStackTrace();  } 
		System.out.println("폴더/파일준비완료~!");    // ctrl + f11 → f5(새로고침)
		
		//#3. byte 파일쓰기    InputStream   > 프로그램  >#  OutputStream  
		// ctrl + shift + f
		try {
			OutputStream output = new FileOutputStream(file);
			output.write('j');
			output.write('a');
			output.write('v');
			output.write('a');
			output.close();
			System.out.println("OutputStream 쓰기완료!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//#4. byte 파일읽기    InputStream  #> 프로그램  >  OutputStream 
		try {
			InputStream input = new FileInputStream(file);
			int cnt=0;
			while(   (cnt = input.read())     !=  -1  ) {    //-1 끝
				System.out.print( (char) cnt);
			}
			input.close();
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}
/*
1. Java I/O
- 입력(input)과 출력(output)
- 두  대상간의 데이터를 주고 받는것
- 스트림이란? 사용 연결통로
		
	입력스트림	→		[프로그램]     →   출력스트림 
		InputStream				OutputStream
		Reader					Writer
 
2. Java I/O 분류
- byte(모든종류-그림, 멀티미디어, 문자)  / char(문자)
- byte(InputStream/OutputStream)   / char (Reader/Writer)

3. 보조스트림
*/



