package com.becasemodule6.repositories;

import com.becasemodule6.models.PlayList;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayListRepo extends PagingAndSortingRepository<PlayList,Long> {
}
