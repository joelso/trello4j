package org.trello4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;

import org.trello4j.model.*;
import org.trello4j.model.Board.Prefs;
import org.trello4j.model.Card.Attachment;
import org.trello4j.model.Checklist.CheckItem;

import com.google.gson.reflect.TypeToken;


/**
 * The Class TrelloImpl.
 */
public class TrelloImpl implements Trello {
	
	/** The Constant GZIP_ENCODING. */
	private static final String GZIP_ENCODING = "gzip";

	/** The api key. */
	private String apiKey = null;
	
	/** The token. */
	private String token = null;
	
	//private String authQueryString = null;
	
	/** The trello obj factory. */
	private TrelloObjectFactoryImpl trelloObjFactory = new TrelloObjectFactoryImpl();
	
	/**
	 * Instantiates a new trello impl.
	 *
	 * @param apiKey the api key
	 */
	public TrelloImpl(String apiKey) {
		this(apiKey, null);
	}

	/**
	 * Instantiates a new trello impl.
	 *
	 * @param apiKey the api key
	 * @param token the token
	 */
	public TrelloImpl(String apiKey, String token) {
		this.apiKey = apiKey;
		this.token = token;
		
		if(this.apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		} 
		
		//this.authQueryString = createAuthQueryString();
	}

	/* (non-Javadoc)
	 * @see org.trello4j.BoardService#getBoard(java.lang.String)
	 */
	@Override
	public Board getBoard(final String boardId) {
		validateObjectId(boardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.BOARD_URL, boardId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<Board>(){}, doApiGet(url));
	}
	
	/* (non-Javadoc)
	 * @see org.trello4j.BoardService#getActionsByBoard(java.lang.String, java.lang.String[])
	 */
	@Override
	public List<Action> getActionsByBoard(final String boardId, final String... filter) {
		validateObjectId(boardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.BOARD_ACTIONS_URL, boardId)
                .token(token)
                .filter(filter)
                .build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>(){}, doApiGet(url));
	}
	

    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getCardsByBoard(java.lang.String)
     */
    @Override
  	public List<Card> getCardsByBoard(String boardId) {
    	validateObjectId(boardId);
    	
  		final String url = TrelloURL
                  .create(apiKey, TrelloURL.BOARD_CARDS_URL, boardId)
                  .token(token)
                  .build();
  		return trelloObjFactory.createObject(new TypeToken<List<Card>>(){}, doApiGet(url));
  	}
      
    
    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getChecklistByBoard(java.lang.String)
     */
    @Override
	public List<Checklist> getChecklistByBoard(String boardId) {
    	validateObjectId(boardId);
    	
		final String url = TrelloURL
                .create(apiKey, TrelloURL.BOARD_CHECKLISTS_URL, boardId)
                .token(token)
                .build();
		return trelloObjFactory.createObject(new TypeToken<List<Checklist>>(){}, doApiGet(url));
	}
    
    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getListByBoard(java.lang.String)
     */
    @Override
  	public List<org.trello4j.model.List> getListByBoard(String boardId) {
    	validateObjectId(boardId);
    	
  		final String url = TrelloURL
                  .create(apiKey, TrelloURL.BOARD_LISTS_URL, boardId)
                  .token(token)
                  .build();
  		return trelloObjFactory.createObject(new TypeToken<List<org.trello4j.model.List>>(){}, doApiGet(url));
  	}
      
    
    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getMembersByBoard(java.lang.String)
     */
    @Override
  	public List<Member> getMembersByBoard(String boardId) {
    	validateObjectId(boardId);
    	
  		final String url = TrelloURL
                  .create(apiKey, TrelloURL.BOARD_MEMBERS_URL, boardId)
                  .token(token)
                  .build();
  		return trelloObjFactory.createObject(new TypeToken<List<Member>>(){}, doApiGet(url));
  	}
      
    
    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getMembersInvitedByBoard(java.lang.String)
     */
    @Override
  	public List<Member> getMembersInvitedByBoard(String boardId) {
    	validateObjectId(boardId);
    	
  		final String url = TrelloURL
                  .create(apiKey, TrelloURL.BOARD_MEMBERS_INVITED_URL, boardId)
                  .token(token)
                  .build();
  		return trelloObjFactory.createObject(new TypeToken<List<Member>>(){}, doApiGet(url));
  	}
      
    
    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getPrefsByBoard(java.lang.String)
     */
    @Override
  	public Prefs getPrefsByBoard(String boardId) {
    	validateObjectId(boardId);
    	
  		final String url = TrelloURL
                  .create(apiKey, TrelloURL.BOARD_PREFS_URL, boardId)
                  .token(token)
                  .build();
  		return trelloObjFactory.createObject(new TypeToken<Prefs>(){}, doApiGet(url));
  	}
	
    
    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getOrganizationByBoard(java.lang.String)
     */
    @Override
  	public Organization getOrganizationByBoard(String boardId) {
    	validateObjectId(boardId);
    	
  		final String url = TrelloURL
                  .create(apiKey, TrelloURL.BOARD_ORGANIZAION_URL, boardId)
                  .token(token)
                  .build();
  		return trelloObjFactory.createObject(new TypeToken<Organization>(){}, doApiGet(url));
  	}
    
    
    /* (non-Javadoc)
     * @see org.trello4j.BoardService#getBoardMyPrefs(java.lang.String)
     */
    @Override
  	public Board getBoardMyPrefs(String boardId) {
    	validateObjectId(boardId);
    	
  		final String url = TrelloURL
                  .create(apiKey, TrelloURL.BOARD_PREFS_URL, boardId)
                  .token(token)
                  .build();
  		return trelloObjFactory.createObject(new TypeToken<Board>(){}, doApiGet(url));
  	}
    
	/* (non-Javadoc)
	 * @see org.trello4j.ActionService#getAction(java.lang.String)
	 */
	@Override
	public Action getAction(final String actionId) {
		validateObjectId(actionId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.ACTION_URL, actionId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<Action>(){}, doApiGet(url));
	}
	


	/* (non-Javadoc)
	 * @see org.trello4j.OrganizationService#getOrganization(java.lang.String)
	 */
	@Override
	public Organization getOrganization(String organizationName) {
		final String url = TrelloURL
                .create(apiKey, TrelloURL.ORGANIZATION_URL, organizationName)
                .token(token)
                .build();
		return trelloObjFactory.createObject(new TypeToken<Organization>(){}, doApiGet(url));
	}
	
	/* (non-Javadoc)
	 * @see org.trello4j.MemberService#getMember(java.lang.String)
	 */
	@Override
	public Member getMember(String usernameOrId) {
		final String url = TrelloURL
                .create(apiKey, TrelloURL.MEMBER_URL, usernameOrId)
                .token(token)
                .build();
		return trelloObjFactory.createObject(new TypeToken<Member>(){}, doApiGet(url));
	}

    /* (non-Javadoc)
     * @see org.trello4j.MemberService#getBoardsByMember(java.lang.String)
     */
    @Override
    public List<Board> getBoardsByMember(String usernameOrId) {
        final String url = TrelloURL
                .create(apiKey, TrelloURL.MEMBER_BOARDS_URL, usernameOrId)
                .token(token)
                .build();
        return trelloObjFactory.createObject(new TypeToken<List<Board>>(){}, doApiGet(url));
    }

    /* (non-Javadoc)
     * @see org.trello4j.OrganizationService#getBoardsByOrganization(java.lang.String)
     */
    @Override
	public List<Board> getBoardsByOrganization(String organizationName) {
		final String url = TrelloURL
                .create(apiKey, TrelloURL.ORGANIZATION_BOARDS_URL, organizationName)
                .token(token)
                .build();
		return trelloObjFactory.createObject(new TypeToken<List<Board>>(){}, doApiGet(url));
	}

    
    /* (non-Javadoc)
     * @see org.trello4j.OrganizationService#getActionsByOrganization(java.lang.String)
     */
    @Override
    public List<Action> getActionsByOrganization(String organizationNameOrId) {
        final String url = TrelloURL
                .create(apiKey, TrelloURL.ORGANIZATION_ACTIONS_URL, organizationNameOrId)
                .token(token)
                .build();
        return trelloObjFactory.createObject(new TypeToken<List<Action>>(){}, doApiGet(url));    
    }

    /* (non-Javadoc)
     * @see org.trello4j.CardService#getCard(java.lang.String)
     */
    @Override
	public Card getCard(final String cardId) {
		validateObjectId(cardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.CARD_URL, cardId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<Card>(){}, doApiGet(url));
	}
	

    /* (non-Javadoc)
     * @see org.trello4j.CardService#getActionsByCard(java.lang.String)
     */
    @Override
	public List<Action> getActionsByCard(final String cardId) {
		validateObjectId(cardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.CARD_ACTION_URL, cardId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>(){}, doApiGet(url));
	}
    
    /* (non-Javadoc)
     * @see org.trello4j.CardService#getAttachementsByCard(java.lang.String)
     */
    @Override
	public List<Attachment> getAttachementsByCard(final String cardId) {
		validateObjectId(cardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.CARD_ATTACHEMENT_URL, cardId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<List<Attachment>>(){}, doApiGet(url));
	}
    
    /* (non-Javadoc)
     * @see org.trello4j.CardService#getBoardByCard(java.lang.String)
     */
    @Override
	public Board getBoardByCard(final String cardId) {
		validateObjectId(cardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.CARD_BOARD_URL, cardId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<Board>(){}, doApiGet(url));
	}
    
    /* (non-Javadoc)
     * @see org.trello4j.CardService#getCheckItemStatesByCard(java.lang.String)
     */
    @Override
	public List<CheckItem> getCheckItemStatesByCard(final String cardId) {
		validateObjectId(cardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.CARD_CHECK_ITEM_STATES_URL, cardId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<List<CheckItem>>(){}, doApiGet(url));
	}
    
    /* (non-Javadoc)
     * @see org.trello4j.CardService#getChecklistByCard(java.lang.String)
     */
    @Override
	public List<Checklist> getChecklistByCard(final String cardId) {
		validateObjectId(cardId);

        final String url = TrelloURL
                .create(apiKey, TrelloURL.CARD_CHECKLISTS_URL, cardId)
                .token(token)
                .build();

		return trelloObjFactory.createObject(new TypeToken<List<Checklist>>(){}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.CardService#getListByCard(java.lang.String)
	 */
	@Override
	public org.trello4j.model.List getListByCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.CARD_LIST_URL, cardId).token(token)
				.build();

		return trelloObjFactory.createObject(
				new TypeToken<org.trello4j.model.List>() {
				}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.CardService#getMembersByCard(java.lang.String)
	 */
	@Override
	public List<Member> getMembersByCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.CARD_MEMBERS_URL, cardId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ListService#getList(java.lang.String)
	 */
	@Override
	public org.trello4j.model.List getList(final String listId) {
		validateObjectId(listId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.LIST_URL, listId).token(token)
				.build();

		return trelloObjFactory.createObject(
				new TypeToken<org.trello4j.model.List>() {
				}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.NotificationService#getNotification(java.lang.String)
	 */
	@Override
	public Notification getNotification(String notificationId) {
		validateObjectId(notificationId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.NOTIFICATION_URL, notificationId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Notification>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ChecklistService#getChecklist(java.lang.String)
	 */
	@Override
	public Checklist getChecklist(String checklistId) {
		validateObjectId(checklistId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.CHECKLIST_URL, checklistId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Checklist>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.Trello#getType(java.lang.String)
	 */
	@Override
	public Type getType(String idOrName) {
		final String url = TrelloURL
				.create(apiKey, TrelloURL.TYPE_URL, idOrName).token(token)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Type>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ActionService#getBoardByAction(java.lang.String)
	 */
	@Override
	public Board getBoardByAction(String actionId) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_BOARD_URL, actionId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ActionService#getCardByAction(java.lang.String)
	 */
	@Override
	public Card getCardByAction(String actionId) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_CARD_URL, actionId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ActionService#getMemberByAction(java.lang.String)
	 */
	@Override
	public Member getMemberByAction(String actionId) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_MEMBER_URL, actionId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ActionService#getListByAction(java.lang.String)
	 */
	@Override
	public org.trello4j.model.List getListByAction(String actionId) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_LIST_URL, actionId)
				.token(token).build();

		return trelloObjFactory.createObject(
				new TypeToken<org.trello4j.model.List>() {
				}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ActionService#getMemberCreatorByAction(java.lang.String)
	 */
	@Override
	public Member getMemberCreatorByAction(String actionId) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_MEMBERCREATOR_URL, actionId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ActionService#getOrganizationByAction(java.lang.String)
	 */
	@Override
	public Organization getOrganizationByAction(String actionId) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_ORGANIZATION_URL, actionId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Organization>() {
		}, doApiGet(url));
	}

	/**
	 * Do api get.
	 *
	 * @param url the url
	 * @return the input stream
	 */
	private InputStream doApiGet(String url) {
		try {
			HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.connect();

			// Return null if we get an error response
			if (conn.getResponseCode() > 399) {
				return null;
			} else {
				return getWrappedInputStream(conn.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(conn
								.getContentEncoding()));
			}
		} catch (IOException e) {
			throw new TrelloException(e.getMessage());
		}
	}

	/**
	 * Validate object id.
	 *
	 * @param id the id
	 */
	private void validateObjectId(String id) {
		if (!TrelloUtil.isObjectIdValid(id)) {
			throw new TrelloException("Invalid object id: " + id);
		}
	}

	/**
	 * Gets the wrapped input stream.
	 *
	 * @param is the is
	 * @param gzip the gzip
	 * @return the wrapped input stream
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private InputStream getWrappedInputStream(InputStream is, boolean gzip)
			throws IOException {
		/*
		 * TODO: What about this? ---------------------- "Java clients which use
		 * java.util.zip.GZIPInputStream() and wrap it with a
		 * java.io.BufferedReader() to read streaming API data will encounter
		 * buffering on low volume streams, since GZIPInputStream's available()
		 * method is not suitable for streaming purposes. To fix this, create a
		 * subclass of GZIPInputStream() which overrides the available()
		 * method."
		 * 
		 * https://dev.twitter.com/docs/streaming-api/concepts#gzip-compression
		 */
		if (gzip) {
			return new BufferedInputStream(new GZIPInputStream(is));
		} else {
			return new BufferedInputStream(is);
		}
	}

	/* (non-Javadoc)
	 * @see org.trello4j.OrganizationService#getMembersByOrganization(java.lang.String)
	 */
	@Override
	public List<Member> getMembersByOrganization(String organizationNameOrId) {

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ORGANIZATION_MEMBERS_URL,
						organizationNameOrId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.NotificationService#getBoardByNotification(java.lang.String)
	 */
	@Override
	public Board getBoardByNotification(String notificationId) {
		validateObjectId(notificationId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.NOTIFICATION_BOARDS_URL,
						notificationId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.NotificationService#getCardByNotification(java.lang.String)
	 */
	@Override
	public Card getCardByNotification(String notificationId) {
		validateObjectId(notificationId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.NOTIFICATION_CARDS_URL,
						notificationId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.NotificationService#getListByNotification(java.lang.String)
	 */
	@Override
	public org.trello4j.model.List getListByNotification(String notificationId) {
		validateObjectId(notificationId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.NOTIFICATION_LIST_URL, notificationId)
				.token(token).build();

		return trelloObjFactory.createObject(
				new TypeToken<org.trello4j.model.List>() {
				}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.NotificationService#getMemberByNotification(java.lang.String)
	 */
	@Override
	public Member getMemberByNotification(String notificationId) {
		validateObjectId(notificationId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.NOTIFICATION_MEMBERS_URL,
						notificationId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.NotificationService#getMemberCreatorByNotification(java.lang.String)
	 */
	@Override
	public Member getMemberCreatorByNotification(String notificationId) {
		validateObjectId(notificationId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.NOTIFICATION_MEMBER_CREATOR_URL,
						notificationId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.NotificationService#getOrganizationCreatorByNotification(java.lang.String)
	 */
	@Override
	public Member getOrganizationCreatorByNotification(String notificationId) {
		validateObjectId(notificationId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.NOTIFICATION_ORGANIZATION_URL,
						notificationId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ListService#getActionsByList(java.lang.String)
	 */
	@Override
	public List<Action> getActionsByList(String listId) {
		validateObjectId(listId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.LIST_ACTIONS_URL, listId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ListService#getBoardByList(java.lang.String)
	 */
	@Override
	public Board getBoardByList(String listId) {
		validateObjectId(listId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.LIST_BOARD_URL, listId).token(token)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ListService#getCardsByList(java.lang.String)
	 */
	@Override
	public List<Card> getCardsByList(String listId) {
		validateObjectId(listId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.LIST_CARDS_URL, listId).token(token)
				.build();

		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.MemberService#getActionsByMember(java.lang.String)
	 */
	@Override
	public List<Action> getActionsByMember(String usernameOrId) {

		final String url = TrelloURL
				.create(apiKey, TrelloURL.MEMBER_ACTIONS_URL, usernameOrId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.MemberService#getCardsByMember(java.lang.String)
	 */
	@Override
	public List<Card> getCardsByMember(String usernameOrId) {

		final String url = TrelloURL
				.create(apiKey, TrelloURL.MEMBER_CARDS_URL, usernameOrId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.MemberService#getNotificationsByMember(java.lang.String)
	 */
	@Override
	public List<Notification> getNotificationsByMember(String usernameOrId) {

		final String url = TrelloURL
				.create(apiKey, TrelloURL.MEMBER_NOTIFIACTIONS_URL,
						usernameOrId).token(token).build();

		return trelloObjFactory.createObject(
				new TypeToken<List<Notification>>() {
				}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.MemberService#getOrganizationsByMember(java.lang.String)
	 */
	@Override
	public List<Organization> getOrganizationsByMember(String usernameOrId) {

		final String url = TrelloURL
				.create(apiKey, TrelloURL.MEMBER_ORGANIZATION_URL, usernameOrId)
				.token(token).build();

		return trelloObjFactory.createObject(
				new TypeToken<List<Organization>>() {
				}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.MemberService#getOrganizationsInvitedByMember(java.lang.String)
	 */
	@Override
	public List<Organization> getOrganizationsInvitedByMember(
			String usernameOrId) {

		final String url = TrelloURL
				.create(apiKey, TrelloURL.MEMBER_ORGANIZATION_INVITED_URL,
						usernameOrId).token(token).build();

		return trelloObjFactory.createObject(
				new TypeToken<List<Organization>>() {
				}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ChecklistService#getBoardByChecklist(java.lang.String)
	 */
	@Override
	public Board getBoardByChecklist(String checklistId) {
		validateObjectId(checklistId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.CHECKLIST_BOARD_URL, checklistId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ChecklistService#getCheckItemsByChecklist(java.lang.String)
	 */
	@Override
	public List<CheckItem> getCheckItemsByChecklist(String checklistId) {
		validateObjectId(checklistId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.CHECKLIST_CHECKITEMS_URL, checklistId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<CheckItem>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.ChecklistService#getCardByChecklist(java.lang.String)
	 */
	@Override
	public List<Card> getCardByChecklist(String checklistId) {
		validateObjectId(checklistId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.CHECKLIST_CARDS_URL, checklistId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.TokenService#getToken(java.lang.String)
	 */
	@Override
	public Token getToken(String tokenId) {
		// validateObjectId(tokenId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.TOKENS_URL, tokenId).token(token)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Token>() {
		}, doApiGet(url));
	}

	/* (non-Javadoc)
	 * @see org.trello4j.TokenService#getMemberByToken(java.lang.String)
	 */
	@Override
	public Member getMemberByToken(String tokenId) {
		// validateObjectId(tokenId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.TOKENS_MEMBER_URL, tokenId)
				.token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doApiGet(url));
	}

}
