package com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage

import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.scope.PerApp
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults
import com.github.nikolaymenzhulin.simple_storage.base_file_storage.BaseSerializableFileStorage
import com.github.nikolaymenzhulin.simple_storage.file_name_generator.SimpleFileNameGenerator
import com.github.nikolaymenzhulin.simple_storage.file_processor.FileProcessor
import javax.inject.Inject

@PerApp
class QuizResultsStorage @Inject constructor(
    cacheDirPath: String
) : BaseSerializableFileStorage<QuizResults>(
    fileProcessor = FileProcessor(cacheDirPath = cacheDirPath, cacheDirName = "quiz_results", maxFilesNumber = 3),
    fileNameGenerator = SimpleFileNameGenerator()
)