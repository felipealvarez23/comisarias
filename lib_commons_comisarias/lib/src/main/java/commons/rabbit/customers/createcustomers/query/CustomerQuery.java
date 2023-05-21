package commons.rabbit.customers.createcustomers.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerQuery {
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String dateOfBirth;
    private String gender;
    private String city;
    private String department;
    private String email;
    private String cellPhone;
    private String address;
}
