package br.com.salesmanager.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Address {

    @NotBlank
    @NotNull
    @Field(name = "recipient")
    private String recipient;

    @NotBlank
    @NotNull
    @Field(name = "street")
    private String street;

    @NotBlank
    @NotNull
    @Field(name = "number")
    private Integer number;

    @NotBlank
    @NotNull
    @Field(name = "zip_code")
    private String zipCode;

    @NotBlank
    @NotNull
    @Field(name = "city")
    private String city;

    @NotBlank
    @NotNull
    @Field(name = "state")
    private String state;

    @NotBlank
    @NotNull
    @Field(name = "country")
    private String country;
}
