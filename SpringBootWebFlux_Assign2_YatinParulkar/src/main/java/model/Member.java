package model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String memberId;
    private String name;
    private String email;  // ✅ Make sure this field is defined
}