package org.example.camping.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long campId;

    @Comment("캠핑장 주인")
    String owner;

    @Comment("캠핑장 이름")
    String campingName;

    @Column(columnDefinition = "TEXT")
    @Comment("캠핑장 설명")
    @Column(columnDefinition = "TEXT")
    String info;

    @Comment("주소1")
    String addr1;

    @Comment("주소2")
    String addr2;

    @Comment("홈페이지")
    String homepage;

    @Comment("부대시설")
    String amenities;

    @Comment("위도")
    Double latitude;

    @Comment("경도")
    Double longitude;

    public Camp(String owner, String campingName, String info, String addr1, String addr2, String homepage, String amenities, Double latitude, Double longitude) {
        this.owner = owner;
        this.campingName = campingName;
        this.info = info;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.homepage = homepage;
        this.amenities = amenities;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
