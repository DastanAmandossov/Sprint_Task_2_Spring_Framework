package org.example.sprint_task_2_spring_boot.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="app_requests")
//нэйм в скбках писать не обязательно, тогда по умолчанию название таблицы будет ApplicationRequest (будет называться как класс)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="username")
    private String userName;
    //колумн писать не обязательно, если название колонки или дефинишн не меняяются


    @Column(name="courseName")
    private String courseName;


    @Column(name="commentary", columnDefinition = "TEXT")
    private String commentary;


    @Column(name="phoneNumber")
    private String phone;


    @Column(name="handled")
    private boolean handled;
}
