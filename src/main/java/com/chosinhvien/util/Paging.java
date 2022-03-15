package com.chosinhvien.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Paging {

    private Integer page;
    private Integer limit;
    private Integer totalPage;
    private Integer totalItem;

}
