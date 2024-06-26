package com.anon.ecom.itemCopy.domain;

import com.anon.ecom.item.domain.ItemDto;
import com.anon.ecom.user.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellOffersDto {
    private Long id;
    private ItemDto item;
    private UserDto seller;
    private BigDecimal price;
    private Integer quantity;
}
