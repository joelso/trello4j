package org.trello4j;

import java.util.Arrays;

public class TrelloURL {
	
	public static final String BOARD_URL                = "https://api.trello.com/1/boards/{0}";
	public static final String BOARD_ACTIONS_URL        = "https://api.trello.com/1/boards/{0}/actions";
	public static final String ACTION_URL               = "https://api.trello.com/1/actions/{0}";
	public static final String ORGANIZATION_URL         = "https://api.trello.com/1/organizations/{0}";
	public static final String ORGANIZATION_BOARDS_URL  = "https://api.trello.com/1/organizations/{0}/boards";
	public static final String ORGANIZATION_ACTIONS_URL = "https://api.trello.com/1/organizations/{0}/actions";
	public static final String MEMBER_URL               = "https://api.trello.com/1/members/{0}";
	public static final String MEMBER_BOARDS_URL        = "https://api.trello.com/1/members/{0}/boards";
	public static final String CARD_URL                 = "https://api.trello.com/1/cards/{0}";
	public static final String LIST_URL                 = "https://api.trello.com/1/lists/{0}";
	public static final String NOTIFICATION_URL         = "https://api.trello.com/1/notifications/{0}";
    public static final String CHECKLIST_URL            = "https://api.trello.com/1/checklists/{0}";
    public static final String TYPE_URL                 = "https://api.trello.com/1/types/{0}";

    private static final String PATH_PARAM_ARG_PREFIX = "\\{";
    private static final String PATH_PARAM_ARG_SUFFIX = "\\}";
    private static final String KEY_QUERY_PARAM = "?key=";
    private static final String TOKEN_QUERY_PARAM = "&token=";
    private static final String FILTER_QUERY_PARAM = "&filter=";

    private final String[] pathParams;
    private final String url;
    private final String apiKey;
    private String token = null;
    private String[] filters = null;

    public static TrelloURL create(String apiKey, String url, String... pathParams) {
        return new TrelloURL(apiKey, url, pathParams);
    }

    private TrelloURL(String apiKey, String url, String... pathParams) {
        this.apiKey = apiKey;
        this.url = url;
        this.pathParams = pathParams;
    }

    public TrelloURL token(String token) {
        this.token = token;
        return this;
    }

    public TrelloURL filter(String... filters) {
        this.filters = isArrayEmpty(filters) ? null : filters;
        return this;
    }

    public String build() {
        if(apiKey == null || url == null) {
            throw new NullPointerException("Cannot build trello URL: API key and URL must be set");
        }

        return new StringBuilder()
                .append(createUrlWithPathParams())
                .append(createAuthQueryString())
                .append(createFilterQuery())
                .toString();
    }

    private String createFilterQuery() {
        String filterStr = "";
        if(this.filters != null) {
            StringBuilder sb = new StringBuilder(FILTER_QUERY_PARAM);
            for(int i=0; i<filters.length; i++) {
                sb.append(i > 0 ? "," : "").append(filters[i]);
            }
            filterStr = sb.toString();
        }
        return filterStr;
    }

    private String createAuthQueryString() {
        StringBuilder sb = new StringBuilder(KEY_QUERY_PARAM).append(apiKey);

        if(this.token != null) {
            sb.append(TOKEN_QUERY_PARAM).append(this.token);
        }
        return sb.toString();
    }

    private String createUrlWithPathParams() {
        String compiledUrl = null;
        for (int i = 0; i < pathParams.length; i++) {
            compiledUrl = url.replaceAll(PATH_PARAM_ARG_PREFIX + i + PATH_PARAM_ARG_SUFFIX, pathParams[i]);
        }
        //boardUrl += authQueryString;
        return compiledUrl;
    }

    private static boolean isArrayEmpty(String[] arr) {
        return arr == null || arr.length == 0;
    }

}
