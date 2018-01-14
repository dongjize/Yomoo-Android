package com.example.dong.yomoo.utils;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by dong on 14/01/2018.
 */

public class SuggestionProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = SuggestionProvider.class.getSimpleName();
    public static final int MODE = SearchRecentSuggestionsProvider.DATABASE_MODE_2LINES
            | SearchRecentSuggestionsProvider.DATABASE_MODE_QUERIES;

    public SuggestionProvider() {
        super();
        setupSuggestions(AUTHORITY, MODE);
    }
}
