package classy.classyapp.BackendApi.globalResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BadRequestExceptionResponse {
    private String message;
    private String cause;
}