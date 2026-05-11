package com.the703.basic016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

//2. Java I/O 분류
//- byte(모든종류-그림, 멀티미디어, 문자)  / char(문자)
//- byte(InputStream/OutputStream)   / char (Reader/Writer)

public class JavaIO003_char {
	public static void main(String[] args) {
		//#1. 경로
		String folder_rel = "src/com/the703/basic016/";  // 상대경로- 현재작업 폴더기준
		String file_path  = "io003_char.txt";
		
		File folder = new  File(folder_rel);
		File file   = new  File(folder_rel + file_path);		
		
		//#2. 폴더+파일만들기 (exsits / mkdirs / createNewFile)
		try {
			if(!folder.exists()) {  folder.mkdirs(); }
			if(!file.exists()) {  file.createNewFile(); }
		}catch(Exception e) { e.printStackTrace(); }
		
		//#3. char 쓰기      Reader(FileReader)    <  [프로그램]  <  # Writer  (FileWriter)
		try {
			Writer writer = new FileWriter(file);
			writer.write("hello\n");
			writer.write("java\n");
			writer.close();
			System.out.println("쓰기완료");
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		//#4. char 읽기     # Reader    <  [프로그램]  < Writer
		try {
			Reader reader = new FileReader(file); 
			int cnt = 0;
			while( (cnt=reader.read())  != -1) {
				System.out.print((char)cnt);
			}
			reader.close();
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







