package com.ohhoonim.test.common;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.ohhoonim.common.util.Utils;
import com.ohhoonim.vo.BookmarkVo;

public class UtilsTest {
	
	@Test
	public void timestampTest2() throws ParseException {
		String strDate = "20180112";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(strDate);
		System.out.println(date.getTime());
	}
	
	@Test
	public void timestampeTest() {
/*
1516170200213
start:1514646000      12
  end:1518274800      2
  
_:1516170315968
  1515369600
start:1511622000      11
end:1515250800        1

*/
		long start = Long.parseLong("1515369600000");
		Date date = new Date(start);
		Date nextMonthDate = DateUtils.addMonths(date, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String strDate = sdf.format(nextMonthDate);
		String strDateOrigin = sdf.format(date);
		assertThat(strDate, is("201802"));
		assertThat(strDateOrigin, is("201801"));
	}
	
	
	
	@Ignore
	@Test
	public void fixedNumberTest() {
		// 파라미터,,, 1: 임의수, 2: 자리수
		String result = Utils.fixedNumber("1", 5);
		assertThat(result, is("00001"));

		result = Utils.fixedNumber("10", 5);
		assertThat(result, is("00010"));
		
		result = Utils.fixedNumber("5235", 5);
		assertThat(result, is("05235"));

		result = Utils.fixedNumber("5235", 10);
		assertThat(result, is("0000005235"));
		
	}
	
	@Ignore
	@Test
	public void grouppingListTest() {
		List<BookmarkVo> list = new ArrayList<BookmarkVo>();
		for(int i = 0; i < 17; i++) {
			BookmarkVo vo = new BookmarkVo();
			vo.setMemId("mem1");
			vo.setCtgr("category" + i);
			
			
			list.add(vo);
	
		}
/*
		Map<String, List<BookmarkVo>> map = Utils.grouppingList(list);
		
		assertThat(map.get("1001").get(0).getCtgr(), is("category0"));
		assertThat(map.get("3001").get(0).getCtgr(), is("category2"));
		assertThat(map.get("3001").get(1).getCtgr(), is("category5"));
		
		
		Set<String> groupIds = map.keySet();
		
		for(String groupId: groupIds) {
			List<BookmarkVo> groupList = map.get(groupId);
			
			for(BookmarkVo vo: groupList) {
				// vo 출력...
			}
			
		}
	*/	
	}
	
}

