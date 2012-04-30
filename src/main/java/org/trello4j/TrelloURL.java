package org.trello4j;

import java.util.Arrays;


/**
 * The Class TrelloURL.
 */
public class TrelloURL {
	
	/** The Constant BOARD_URL. */
	public static final String BOARD_URL                = "https://api.trello.com/1/boards/{0}";
	
	/** The Constant BOARD_ACTIONS_URL. */
	public static final String BOARD_ACTIONS_URL        = "https://api.trello.com/1/boards/{0}/actions";
	
	/** The Constant ACTION_URL. */
	public static final String ACTION_URL               = "https://api.trello.com/1/actions/{0}";
	
	/** The Constant ORGANIZATION_URL. */
	public static final String ORGANIZATION_URL         = "https://api.trello.com/1/organizations/{0}";
	
	/** The Constant ORGANIZATION_BOARDS_URL. */
	public static final String ORGANIZATION_BOARDS_URL  = "https://api.trello.com/1/organizations/{0}/boards";
	
	/** The Constant ORGANIZATION_ACTIONS_URL. */
	public static final String ORGANIZATION_ACTIONS_URL = "https://api.trello.com/1/organizations/{0}/actions";
	
	/** The Constant MEMBER_URL. */
	public static final String MEMBER_URL               = "https://api.trello.com/1/members/{0}";
	
	/** The Constant MEMBER_BOARDS_URL. */
	public static final String MEMBER_BOARDS_URL        = "https://api.trello.com/1/members/{0}/boards";
	
	/** The Constant CARD_URL. */
	public static final String CARD_URL                 = "https://api.trello.com/1/cards/{0}";
	
	/** The Constant LIST_URL. */
	public static final String LIST_URL                 = "https://api.trello.com/1/lists/{0}";
	
	/** The Constant NOTIFICATION_URL. */
	public static final String NOTIFICATION_URL         = "https://api.trello.com/1/notifications/{0}";
    
    /** The Constant CHECKLIST_URL. */
    public static final String CHECKLIST_URL            = "https://api.trello.com/1/checklists/{0}";
    
    /** The Constant TYPE_URL. */
    public static final String TYPE_URL                 = "https://api.trello.com/1/types/{0}";

	/** The Constant ACTION_BOARD_URL. */
	public static final String ACTION_BOARD_URL         = "https://api.trello.com/1/actions/{0}/board";
	
	/** The Constant ACTION_CARD_URL. */
	public static final String ACTION_CARD_URL          = "https://api.trello.com/1/actions/{0}/card";
	
	/** The Constant ACTION_MEMBER_URL. */
	public static final String ACTION_MEMBER_URL        = "https://api.trello.com/1/actions/{0}/member";
	
	/** The Constant ACTION_LIST_URL. */
	public static final String ACTION_LIST_URL          = "https://api.trello.com/1/actions/{0}/list";
	
	/** The Constant ACTION_MEMBERCREATOR_URL. */
	public static final String ACTION_MEMBERCREATOR_URL = "https://api.trello.com/1/actions/{0}/memberCreator";
	
	/** The Constant ACTION_ORGANIZATION_URL. */
	public static final String ACTION_ORGANIZATION_URL  = "https://api.trello.com/1/actions/{0}/organisation";
    
	
	/** The Constant BOARD_CARDS_URL. */
	public static final String BOARD_CARDS_URL 			= "https://api.trello.com/1/boards/{0}/cards";
	
	/** The Constant BOARD_CHECKLISTS_URL. */
	public static final String BOARD_CHECKLISTS_URL 	= "https://api.trello.com/1/boards/{0}/checklists";
	
	/** The Constant BOARD_LISTS_URL. */
	public static final String BOARD_LISTS_URL 			= "https://api.trello.com/1/boards/{0}/lists";
	
	/** The Constant BOARD_MEMBERS_URL. */
	public static final String BOARD_MEMBERS_URL 		= "https://api.trello.com/1/boards/{0}/members";
	
	/** The Constant BOARD_MEMBERS_INVITED_URL. */
	public static final String BOARD_MEMBERS_INVITED_URL= "https://api.trello.com/1/boards/{0}/membersInvited";
	
	/** The Constant BOARD_PREFS_URL. */
	public static final String BOARD_PREFS_URL 			= "https://api.trello.com/1/boards/{0}/myPrefs";
	
	/** The Constant BOARD_ORGANIZAION_URL. */
	public static final String BOARD_ORGANIZAION_URL 	= "https://api.trello.com/1/boards/{0}/organization";
	
	/** The Constant BOARD_CLOSED_URL. */
	public static final String BOARD_CLOSED_URL 		= "https://api.trello.com/1/boards/{0}/closed";

	
	/** The Constant CARD_ACTION_URL. */
	public static final String CARD_ACTION_URL 			= "https://api.trello.com/1/cards/{0}/actions";
	
	/** The Constant CARD_ATTACHEMENT_URL. */
	public static final String CARD_ATTACHEMENT_URL 	= "https://api.trello.com/1/cards/{0}/attachments";
	
	/** The Constant CARD_BOARD_URL. */
	public static final String CARD_BOARD_URL	 		= "https://api.trello.com/1/cards/{0}/board";
	
	/** The Constant CARD_CHECK_ITEM_STATES_URL. */
	public static final String CARD_CHECK_ITEM_STATES_URL = "https://api.trello.com/1/cards/{0}/checkItemStates";
	
	/** The Constant CARD_CHECKLISTS_URL. */
	public static final String CARD_CHECKLISTS_URL 		= "https://api.trello.com/1/cards/{0}/checklists";
	
	/** The Constant CARD_LIST_URL. */
	public static final String CARD_LIST_URL 			= "https://api.trello.com/1/cards/{0}/list";
	
	/** The Constant CARD_MEMBERS_URL. */
	public static final String CARD_MEMBERS_URL 		= "https://api.trello.com/1/cards/{0}/members";
    
	
	/** The Constant LIST_ACTIONS_URL. */
	public static final String LIST_ACTIONS_URL                 = "https://api.trello.com/1/lists/{0}/action";
	
	/** The Constant LIST_BOARD_URL. */
	public static final String LIST_BOARD_URL                 = "https://api.trello.com/1/lists/{0}/board";
	
	/** The Constant LIST_CARDS_URL. */
	public static final String LIST_CARDS_URL                 = "https://api.trello.com/1/lists/{0}/cards";

	
	/** The Constant MEMBER_ACTIONS_URL. */
	public static final String MEMBER_ACTIONS_URL        			= "https://api.trello.com/1/members/{0}/actions";
	
	/** The Constant MEMBER_BOARD_INVITED_URL. */
	public static final String MEMBER_BOARD_INVITED_URL  			= "https://api.trello.com/1/members/{0}/boardInvited";
	
	/** The Constant MEMBER_CARDS_URL. */
	public static final String MEMBER_CARDS_URL        				= "https://api.trello.com/1/members/{0}/cards";
	
	/** The Constant MEMBER_NOTIFIACTIONS_URL. */
	public static final String MEMBER_NOTIFIACTIONS_URL       		= "https://api.trello.com/1/members/{0}/notifications";
	
	/** The Constant MEMBER_ORGANIZATION_URL. */
	public static final String MEMBER_ORGANIZATION_URL        		= "https://api.trello.com/1/members/{0}/organizations";
	
	/** The Constant MEMBER_ORGANIZATION_INVITED_URL. */
	public static final String MEMBER_ORGANIZATION_INVITED_URL       = "https://api.trello.com/1/members/{0}/organizationsInvited";
	
	/** The Constant NOTIFICATION_ACTIONS_URL. */
	public static final String NOTIFICATION_ACTIONS_URL             = "https://api.trello.com/1/notifications/{0}/actions";
	
	/** The Constant NOTIFICATION_BOARDS_URL. */
	public static final String NOTIFICATION_BOARDS_URL              = "https://api.trello.com/1/notifications/{0}/boards";
	
	/** The Constant NOTIFICATION_MEMBERS_URL. */
	public static final String NOTIFICATION_MEMBERS_URL             = "https://api.trello.com/1/notifications/{0}/members";
	
	/** The Constant NOTIFICATION_CARDS_URL. */
	public static final String NOTIFICATION_CARDS_URL			    = "https://api.trello.com/1/notifications/{0}/cards";
	
	/** The Constant NOTIFICATION_LIST_URL. */
	public static final String NOTIFICATION_LIST_URL			    = "https://api.trello.com/1/notifications/{0}/list";
	
	/** The Constant NOTIFICATION_MEMBER_CREATOR_URL. */
	public static final String NOTIFICATION_MEMBER_CREATOR_URL	    = "https://api.trello.com/1/notifications/{0}/membersCreator";
	
	/** The Constant NOTIFICATION_ORGANIZATION_URL. */
	public static final String NOTIFICATION_ORGANIZATION_URL		= "https://api.trello.com/1/notifications/{0}/organization";
	
	
	/** The Constant CHECKLIST_BOARD_URL. */
	public static final String CHECKLIST_BOARD_URL					= "https://api.trello.com/1/checklists/{0}/board";
	
	/** The Constant CHECKLIST_CHECKITEMS_URL. */
	public static final String CHECKLIST_CHECKITEMS_URL 		    = "https://api.trello.com/1/checklists/{0}/checkItems";
	
	/** The Constant CHECKLIST_CARDS_URL. */
	public static final String CHECKLIST_CARDS_URL 		    		= "https://api.trello.com/1/checklists/{0}/cards";
	
	/** The Constant TOKENS_URL. */
	public static final String TOKENS_URL        					= "https://api.trello.com/1/tokens/{0}";
	
	/** The Constant TOKENS_MEMBER_URL. */
	public static final String TOKENS_MEMBER_URL         			= "https://api.trello.com/1/tokens/{0}/member";
	
	/** The Constant ORGANIZATION_MEMBERS_URL. */
	public static final String ORGANIZATION_MEMBERS_URL 			= "https://api.trello.com/1/organizations/{0}/members";
	
    /** The Constant PATH_PARAM_ARG_PREFIX. */
    private static final String PATH_PARAM_ARG_PREFIX = "\\{";
    
    /** The Constant PATH_PARAM_ARG_SUFFIX. */
    private static final String PATH_PARAM_ARG_SUFFIX = "\\}";
    
    /** The Constant KEY_QUERY_PARAM. */
    private static final String KEY_QUERY_PARAM = "?key=";
    
    /** The Constant TOKEN_QUERY_PARAM. */
    private static final String TOKEN_QUERY_PARAM = "&token=";
    
    /** The Constant FILTER_QUERY_PARAM. */
    private static final String FILTER_QUERY_PARAM = "&filter=";
    


    /** The path params. */
    private final String[] pathParams;
    
    /** The url. */
    private final String url;
    
    /** The api key. */
    private final String apiKey;
    
    /** The token. */
    private String token = null;
    
    /** The filters. */
    private String[] filters = null;

    /**
     * Creates the.
     *
     * @param apiKey the api key
     * @param url the url
     * @param pathParams the path params
     * @return the trello url
     */
    public static TrelloURL create(String apiKey, String url, String... pathParams) {
        return new TrelloURL(apiKey, url, pathParams);
    }

    /**
     * Instantiates a new trello url.
     *
     * @param apiKey the api key
     * @param url the url
     * @param pathParams the path params
     */
    private TrelloURL(String apiKey, String url, String... pathParams) {
        this.apiKey = apiKey;
        this.url = url;
        this.pathParams = pathParams;
    }

    /**
     * Token.
     *
     * @param token the token
     * @return the trello url
     */
    public TrelloURL token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Filter.
     *
     * @param filters the filters
     * @return the trello url
     */
    public TrelloURL filter(String... filters) {
        this.filters = isArrayEmpty(filters) ? null : filters;
        return this;
    }

    /**
     * Builds the.
     *
     * @return the string
     */
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

    /**
     * Creates the filter query.
     *
     * @return the string
     */
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

    /**
     * Creates the auth query string.
     *
     * @return the string
     */
    private String createAuthQueryString() {
        StringBuilder sb = new StringBuilder(KEY_QUERY_PARAM).append(apiKey);

        if(this.token != null) {
            sb.append(TOKEN_QUERY_PARAM).append(this.token);
        }
        return sb.toString();
    }

    /**
     * Creates the url with path params.
     *
     * @return the string
     */
    private String createUrlWithPathParams() {
        String compiledUrl = null;
        for (int i = 0; i < pathParams.length; i++) {
            compiledUrl = url.replaceAll(PATH_PARAM_ARG_PREFIX + i + PATH_PARAM_ARG_SUFFIX, pathParams[i]);
        }
        //boardUrl += authQueryString;
        return compiledUrl;
    }

    /**
     * Checks if is array empty.
     *
     * @param arr the arr
     * @return true, if is array empty
     */
    private static boolean isArrayEmpty(String[] arr) {
        return arr == null || arr.length == 0;
    }

}
