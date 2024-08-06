package org.example.camping.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.camping.domain.entity.Camp;
import org.example.camping.domain.repository.CampRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampService {

    private final CampRepository campRepository;

    public void createCampingInfo() throws ParserConfigurationException, IOException, SAXException {
        String url = "https://apis.data.go.kr/B551011/GoCamping/locationBasedList?serviceKey=d0quf9M3h%2BYX4z2RmQIYBYuNYLKclAhViz20uwl4K1NEJDovNE1kx9whMctnnY7Kj11YHAYRepRqEQ1WmP%2BGtg%3D%3D&numOfRows=61&pageNo=1&MobileOS=ETC&MobileApp=AppTest&mapX=126.533667&mapY=33.35225&radius=20000";

        // XML 데이터를 파싱하기 위한 DocumentBuilder 객체 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url);

        // XML 문서의 루트 엘리먼트 가져오기
        Element rootElement = document.getDocumentElement();

        // 필요한 데이터를 추출하기 위해 노드 리스트 가져오기
        NodeList itemList = rootElement.getElementsByTagName("item");
        System.out.println(itemList.getLength());
        for (int i = 0; i < itemList.getLength(); i++) {
            Element item = (Element) itemList.item(i);

            // 각 아이템에서 필요한 데이터 추출
            String owner = getTagValue(item, "facltDivNm");
            String campingName = getTagValue(item, "facltNm");
            String info = getTagValue(item, "intro");
            String addr1 = getTagValue(item, "addr1");
            String addr2 = getTagValue(item, "addr2");
            String homepage = getTagValue(item, "homepage");
            String amenities = getTagValue(item, "sbrsCl");
            String latitude = getTagValue(item, "mapY");
            String longitude = getTagValue(item, "mapX");

            // 추출한 데이터 출력 (또는 다른 처리)
            System.out.println("캠핑장 소유자: " + owner);
            System.out.println("캠핑장 이름: " + campingName);
            System.out.println("소개: " + info);
            System.out.println(info.length());
            System.out.println("주소 1: " + addr1);
            System.out.println("주소 2: " + addr2);
            System.out.println("홈페이지: " + homepage);
            System.out.println("편의시설: " + amenities);
            System.out.println("위도: " + latitude);
            System.out.println("경도: " + longitude);
            System.out.println("--------------------");

            Camp camping = new Camp(owner, campingName, info, addr1, addr2, homepage, amenities, Double.parseDouble(latitude), Double.parseDouble(longitude));



            campRepository.save(camping);
        }
    }

    private String getTagValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            return nodeList.item(0).getTextContent();
        }
        return "N/A";
    }

    public List<Camp> getCampingInfo() {
        return campRepository.findAll();
    }

}
