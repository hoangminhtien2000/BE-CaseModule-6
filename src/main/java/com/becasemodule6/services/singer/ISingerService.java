package com.becasemodule6.services.singer;

import com.becasemodule6.models.Singer;
import com.becasemodule6.services.CrudService;

public interface ISingerService extends CrudService<Singer> {
    Singer findSingerBySinger_name(String singer_name);
}
