package com.practise.jaypractise.models.learnmokito;

public interface TranslationService {

    default String translate(String text, String sourceLang, String targetLang) {
        return text;
    }
}
