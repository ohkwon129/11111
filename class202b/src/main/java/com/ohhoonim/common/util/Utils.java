package com.ohhoonim.common.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ohhoonim.vo.BookmarkVo;
public class Utils {
	private static final Logger LOGGER = Logger.getLogger(Utils.class);
	
	// 빈 값을 받을 때 null 을 "" 로 변환
	public static String toEmptyBlank(String nullStr){
		return nullStr == null ? "" : nullStr;	
	}
	
	public static String customToEmptyBlank(String nullStr, String modifiedStr){
		return nullStr == null ? modifiedStr : nullStr;	
	}
	
	public static String webBlankToCustomize(String inputStr, String modifedStr){
		return inputStr == "" ? modifedStr : inputStr;
	}
	
	
	// html환경에서 null일때 스페이스로
	public static String nullSpace(String nullSpa) {
	      return nullSpa == null ? "&nbsp;" : nullSpa;
	   }
	
	// date 형식으로 변환 후 원하는 포맷으로 변경
	public static String dateFommatter(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String modifyDate ="";
		String setDateStr = dateStr;
		
		try {
			if (setDateStr == null || setDateStr == ""){
				setDateStr = "2020-12-31";
			}
			
			LOGGER.debug("=======================================================");
			LOGGER.debug("입력받은 날짜 : " + setDateStr);
			LOGGER.debug("=======================================================");
			
			date = sdf.parse(setDateStr);
			LOGGER.debug("=======================================================");
			LOGGER.debug("변환된 날짜 : " + date);
			LOGGER.debug("=======================================================");
			modifyDate= sdf2.format(date);
			
			LOGGER.debug("=======================================================");
			LOGGER.debug("수정된 날짜 : " + modifyDate);
			LOGGER.debug("=======================================================");
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return modifyDate;
	}
	
	//String date 를 받아서 10자리만 커트
	public static String customDate(String dateStr){
		String customDate = dateStr.substring(0, 10);
		return customDate;
	}
	
	//숫자를 원하는 포맷으로 변경
	public static String customNum(String strNum, String format){
		int intNum = Integer.parseInt(strNum);
		DecimalFormat df = new DecimalFormat(format);
		String customNum = df.format(intNum);
		
		return customNum;
	}
	
	// 입력받은 문자열이 숫자 형식인지 체크
	public static boolean chkInputOnlyNumber(String input){
		char chrInput = 0;
		boolean result = false;
		
		if (input == ""){
			result = true;
		}else{
			int inputLen = input.length();
			for (int i = 0; i < inputLen; i++ ){
				chrInput = input.charAt(i);
				if(chrInput >= 0x30 && chrInput <= 0x39){
					result = true;
				}else if (chrInput == 32){
					result = true;
				}else if (chrInput == 46){
					result = true;
				}else{
					result = false;
					break;
				}
				
			}
		}
		
		
		
		return result;
	}
	
	// 입력받은 문자열이 영문인지 체크
	public static boolean chkInputOnlyAlphabet(String input){
		char chrInput = 0;
		boolean result = false;
		
		int inputLen = input.length();
		for (int i = 0; i < inputLen; i++ ){
			chrInput = input.charAt(i);
			if(chrInput >= 0x61 && chrInput <= 0x7A){
				result = true;
			}else if(chrInput >= 0x41 && chrInput <= 0x5A){
				result = true;
			}else if(chrInput == 32){
				result = true;
			}
			else{
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	// 입력받은 문자열이 영문소문자인지 체크
	public static boolean chkInputOnlyLowerAlphabet(String input){
		char chrInput = 0;
		boolean result = false;
		
		int inputLen = input.length();
		for (int i = 0; i < inputLen; i++ ){
			chrInput = input.charAt(i);
			if(chrInput >= 0x61 && chrInput <= 0x7A || chrInput == 32){
				result = true;
			}else{
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	// 입력받은 문자열이 영문대문자인지 체크
	public static boolean chkInputOnlyUpperAlphabet(String input){
		char chrInput = 0;
		boolean result = false;
		
		int inputLen = input.length();
		for (int i = 0; i < inputLen; i++ ){
			chrInput = input.charAt(i);
			if(chrInput >= 0x41 && chrInput <= 0x5A || chrInput == 32){
				result = true;
			}else {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	
	// 입력받은 문자열이 한글인지 체크
	public static boolean chkInputOnlyKorean(String input){
		char chrInput = 0;
		boolean result = false;
		
		int inputLen = input.length();
		for (int i = 0; i < inputLen; i++ ){
			chrInput = input.charAt(i);
			if(chrInput >= 44032 && chrInput <= 55203 || chrInput == 32){
				result = true;
			}else{
				result = false;
				break;
			}
			
		}
		
		return result;
	}
	
	// null 이거나 "" 이면 true를 반환
	public static boolean isEmpty(String req) {
		return req == null || req.equals("") ? true: false;
	}

//	시리얼 넘버 생성기
	public static String fixedNumber(String anyNum, int numOfDigit) {
		StringBuffer sb = new StringBuffer();
		int makeLength = numOfDigit - anyNum.length();
		for (int i = 0; i < makeLength; i++ ) {
			sb = sb.append("0");
		}
		sb = sb.append(anyNum);
		return sb.toString();
	}
	
	public static  Map<String, List<Map<String, Object>>> grouppingList(List<Map<String, Object>> list) {
		Map<String, List<Map<String, Object>>> groupedList = new HashMap<String, List<Map<String, Object>>>();
		
		for(Map<String, Object> item: list) {
			String groupId = item.get("idx").toString() == null? "": item.get("idx").toString();
//			if (groupId == null || groupId.length() == 0) {
//				groupId = "unsorted";
//			}
//			
			List<Map<String, Object>> row = groupedList.get(groupId);
			
			if (row == null) {
				row = new ArrayList<Map<String, Object>>();
			} 
			row.add(item);
			groupedList.put(groupId, row);
		}
		
		return groupedList;
		
	}
	
}



















