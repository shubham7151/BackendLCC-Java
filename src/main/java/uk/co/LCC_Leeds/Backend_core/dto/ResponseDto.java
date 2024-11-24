package uk.co.LCC_Leeds.Backend_core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private String statusCode;
    private String statusMsg;
    private T data;
}
