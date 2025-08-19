package com.cafe24.server.domain.user;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "places")
@Getter
@Setter
public class Place {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String type;

    private String address;

    private Double latitude;
    private Double longitude;

    private String additional;

    @Column(name = "group_name")
    private String groupName;

    private String internet;
    private String number;
    private String parking;

    @Column(name = "table_info")
    private String tableInfo;

    private String toilet;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
