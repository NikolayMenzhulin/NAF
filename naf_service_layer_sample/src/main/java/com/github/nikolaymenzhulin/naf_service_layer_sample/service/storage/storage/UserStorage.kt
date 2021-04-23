package com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.storage

import com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.model.UserSM
import com.github.nikolaymenzhulin.simple_storage.base_file_storage.BaseGsonFileStorage
import com.github.nikolaymenzhulin.simple_storage.file_name_generator.SimpleFileNameGenerator
import com.github.nikolaymenzhulin.simple_storage.file_processor.FileProcessor

class UserStorage(cacheDirPath: String) : BaseGsonFileStorage<UserSM>(
    fileProcessor = FileProcessor(cacheDirPath = cacheDirPath, cacheDirName = "users_cache", maxFilesNumber = 5),
    fileNameGenerator = SimpleFileNameGenerator(),
    classType = UserSM::class.java
)