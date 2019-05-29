package json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonBook {

	public static void main(String[] args) {
		System.out.println("--------------------------------------------");
		List<BookDTO> bList = new ArrayList<BookDTO>();
		bList.add(new BookDTO("전쟁과 평화", "톨스토이", 20000, "소설", "톨스토이 출판사"));
		bList.add(new BookDTO("홍길동전", "허균", 30000, "소설", "허균 출판사"));
		bList.add(new BookDTO("레미제라블", "빅토르 위고", 10000, "소설", "위고 출판사"));
		
		System.out.println("JSON String 생성");
		JSONObject jObj = new JSONObject();
		JSONArray jArray = new JSONArray();
		for(BookDTO bDto : bList) {
			JSONObject book = new JSONObject();
			book.put("name", bDto.getName());
			book.put("witer", bDto.getWriter());
			book.put("price", bDto.getPrice());
			book.put("genre", bDto.getGenre());
			book.put("publisher", bDto.getPublisher());
			jArray.add(book);
			System.out.println(bDto.toString());
		}
		jObj.put("BookList", jArray);
		
		System.out.println(jObj.toString());
		
		System.out.println("--------------------------------------------");
		System.out.println("JSON String 파싱");
		try {
			JSONArray rbook = (JSONArray) jObj.get("BookList");
			System.out.println("size : " + rbook.size());
			for(int i=0; i<rbook.size(); i++) {
				JSONObject rrbook = (JSONObject) rbook.get(i);
				BookDTO bDto = new BookDTO();
				bDto.setName((String) rrbook.get("name"));
				bDto.setWriter((String) rrbook.get("witer"));
				bDto.setPrice((int) rrbook.get("price"));
				bDto.setGenre((String) rrbook.get("genre"));
				bDto.setPublisher((String) rrbook.get("publisher"));
				System.out.println(bDto.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------");
	}
}
