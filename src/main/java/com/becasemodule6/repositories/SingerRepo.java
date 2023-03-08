package com.becasemodule6.repositories;

import com.becasemodule6.models.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SingerRepo extends PagingAndSortingRepository<Singer, Long> {
}
