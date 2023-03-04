package dev.cequell.openpkm.main_module.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedDto<T> {
    public List<T> data;
    public int offset;
    public int page;
}
