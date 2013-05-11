package org.trello4j;

import static java.lang.String.format;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;

import org.trello4j.core.ActionOperations;
import org.trello4j.core.BoardOperations;
import org.trello4j.core.CardOperations;
import org.trello4j.core.ChecklistOperations;
import org.trello4j.core.DefaultActionOperations;
import org.trello4j.core.DefaultBoardOperations;
import org.trello4j.core.DefaultCardOperations;
import org.trello4j.core.DefaultChecklistOperations;
import org.trello4j.core.DefaultListOperations;
import org.trello4j.core.DefaultMemberOperations;
import org.trello4j.core.DefaultNotificationOperations;
import org.trello4j.core.DefaultOrganizationOperations;
import org.trello4j.core.DefaultTokenOperations;
import org.trello4j.core.ListOperations;
import org.trello4j.core.MemberOperations;
import org.trello4j.core.NotificationOperations;
import org.trello4j.core.OrganizationOperations;
import org.trello4j.core.TokenOperations;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.Prefs;
import org.trello4j.model.Card;
import org.trello4j.model.Card.Attachment;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;
import org.trello4j.model.Token;
import org.trello4j.model.Type;

import com.google.gson.reflect.TypeToken;

/**
 * The Class TrelloImpl.
 */
public class TrelloImpl implements Trello {

	private static final String METHOD_DELETE = "DELETE";
	private static final String METHOD_GET = "GET";
	private static final String METHOD_POST = "POST";
	private static final String METHOD_PUT = "PUT";
	private static final String GZIP_ENCODING = "gzip";

	private String apiKey = null;
	private String token = null;
	private TrelloObjectFactoryImpl trelloObjFactory = new TrelloObjectFactoryImpl();

	private final ActionOperations actionOperationsDelegate;
	private final OrganizationOperations organizationOperationsDelegate;
	private final ListOperations listOperationsDelegate;
	private final ChecklistOperations checklistOperations;
	private final MemberOperations memberOperations;
	private final BoardOperations boardOperations;
	private final NotificationOperations notificationOperations;
	private final CardOperations cardOperations;
	private final TokenOperations tokenOperations;

	public TrelloImpl(String apiKey) {
		this(apiKey, null);
	}

	public TrelloImpl(String apiKey, String token) {
		this.apiKey = apiKey;
		this.token = token;

		if (this.apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		}

		actionOperationsDelegate = new DefaultActionOperations(apiKey, token, trelloObjFactory);
		organizationOperationsDelegate = new DefaultOrganizationOperations(apiKey, token, trelloObjFactory);
		listOperationsDelegate = new DefaultListOperations(apiKey, token, trelloObjFactory);
		checklistOperations = new DefaultChecklistOperations(apiKey, token, trelloObjFactory);
		memberOperations = new DefaultMemberOperations(apiKey, token, trelloObjFactory);
		boardOperations = new DefaultBoardOperations(apiKey, token, trelloObjFactory);
		notificationOperations = new DefaultNotificationOperations(apiKey, token, trelloObjFactory);
		cardOperations = new DefaultCardOperations(apiKey, token, trelloObjFactory);
		tokenOperations = new DefaultTokenOperations(apiKey, token, trelloObjFactory);
	}

	@Override
	public Board getBoard(final String boardId) {
		return boardOperations.getBoard(boardId);
	}

	@Override
	public List<Action> getActionsByBoard(final String boardId, final String... filter) {
		return boardOperations.getActionsByBoard(boardId, filter);
	}

	@Override
	public List<Card> getCardsByBoard(String boardId, final String... filter) {
		return boardOperations.getCardsByBoard(boardId, filter);
	}

	@Override
	public List<Checklist> getChecklistByBoard(String boardId) {
		return boardOperations.getChecklistByBoard(boardId);
	}

	@Override
	public List<org.trello4j.model.List> getListByBoard(String boardId, final String... filter) {
		return boardOperations.getListByBoard(boardId, filter);
	}

	@Override
	public List<Member> getMembersByBoard(String boardId, final String... filter) {
		return boardOperations.getMembersByBoard(boardId, filter);
	}

	@Override
	public List<Member> getMembersInvitedByBoard(String boardId, final String... filter) {
		return boardOperations.getMembersInvitedByBoard(boardId, filter);
	}

	@Override
	public Prefs getPrefsByBoard(String boardId) {
		return boardOperations.getPrefsByBoard(boardId);
	}

	@Override
	public Organization getOrganizationByBoard(String boardId, final String... filter) {
		return boardOperations.getOrganizationByBoard(boardId, filter);
	}

	@Override
	public Member getMember(String usernameOrId, final String... filter) {
		return memberOperations.getMember(usernameOrId, filter);
	}

	@Override
	public List<Board> getBoardsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getBoardsByMember(usernameOrId, filter);
	}

	@Override
	public Card getCard(final String cardId) {
		return cardOperations.getCard(cardId);
	}

	@Override
	public List<Action> getActionsByCard(final String cardId) {
		return cardOperations.getActionsByCard(cardId);
	}

	@Override
	public List<Attachment> getAttachmentsByCard(final String cardId) {
		return cardOperations.getAttachmentsByCard(cardId);
	}

	@Override
	public Board getBoardByCard(final String cardId, final String... filter) {
		return cardOperations.getBoardByCard(cardId, filter);
	}

	@Override
	public List<CheckItem> getCheckItemStatesByCard(final String cardId) {
		return cardOperations.getCheckItemStatesByCard(cardId);
	}

	@Override
	public List<Checklist> getChecklistByCard(final String cardId) {
		return cardOperations.getChecklistByCard(cardId);
	}

	@Override
	public org.trello4j.model.List getListByCard(final String cardId, final String... filter) {
		return cardOperations.getListByCard(cardId, filter);
	}

	@Override
	public List<Member> getMembersByCard(final String cardId) {
		return cardOperations.getMembersByCard(cardId);
	}

	@Override
	public Card createCard(String idList, String name, Map<String, Object> keyValueMap, String... filter) {
		return cardOperations.createCard(idList, name, keyValueMap, filter);
	}

	@Override
	public Action commentOnCard(String idCard, String text, String... filter) {
		return cardOperations.commentOnCard(idCard, text, filter);
	}

	@Override
	public List<Attachment> attachToCard(String idCard, File file, URL attachmentUrl, String name, String mimeType, String... filter) {
		return cardOperations.attachToCard(idCard, file, attachmentUrl, name, mimeType, filter);
	}

	@Override
	public Checklist addChecklist(String idCard, String idChecklist, String checklistName, String idChecklistSource, String... filter) {
		return cardOperations.addChecklist(idCard, idChecklist, checklistName, idChecklistSource, filter);
	}

	@Override
	public List<Card.Label> addLabel(String idCard, String label, String... filter) {
		return cardOperations.addLabel(idCard, label, filter);
	}

	@Override
	public List<Member> addMember(String idCard, String memberId, String... filter) {
		return cardOperations.addMember(idCard, memberId, filter);
	}

	@Override
	public boolean voteOnCard(String idCard, String memberId, String... filter) {
		return voteOnCard(idCard, memberId, filter);
	}

	@Override
	public List<Member> getMemberVotesOnCard(String idCard, String... filter) {
		return cardOperations.getMemberVotesOnCard(idCard, filter);
	}

	@Override
	public boolean deleteCard(String idCard, String... filter) {
		return cardOperations.deleteCard(idCard, filter);
	}

	@Override
	public boolean deleteChecklistFromCard(String idCard, String idList, String... filter) {
		return cardOperations.deleteChecklistFromCard(idCard, idList, filter);
	}

	@Override
	public boolean deleteLabelFromCard(String idCard, String color, String... filter) {
		return cardOperations.deleteLabelFromCard(idCard, color, filter);
	}

	@Override
	public boolean deleteMemberFromCard(String idCard, String idMember, String... filter) {
		return cardOperations.deleteMemberFromCard(idCard, idMember, filter);
	}

	@Override
	public boolean deleteVoteFromCard(String idCard, String memberId, String... filter) {
		return deleteVoteFromCard(idCard, memberId, filter);
	}

	@Override
	public org.trello4j.model.List getList(final String listId) {
		return listOperationsDelegate.getList(listId);
	}

	@Override
	public Notification getNotification(String notificationId, final String... filter) {
		return notificationOperations.getNotification(notificationId, filter);
	}

	@Override
	public Checklist getChecklist(String checklistId, final String... filter) {
		return checklistOperations.getChecklist(checklistId, filter);
	}

	@Override
	public Type getType(String idOrName) {
		final String url = TrelloURL.create(apiKey, TrelloURL.TYPE_URL, idOrName).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Type>() {
		}, doGet(url));
	}

	@Override
	public Board getBoardByNotification(String notificationId, final String... filter) {
		return notificationOperations.getBoardByNotification(notificationId, filter);
	}

	@Override
	public Card getCardByNotification(String notificationId, final String... filter) {
		return notificationOperations.getCardByNotification(notificationId, filter);
	}

	@Override
	public org.trello4j.model.List getListByNotification(String notificationId, final String... filter) {
		return notificationOperations.getListByNotification(notificationId, filter);
	}

	@Override
	public Member getMemberByNotification(String notificationId, final String... filter) {
		return notificationOperations.getMemberByNotification(notificationId, filter);
	}

	@Override
	public Member getMemberCreatorByNotification(String notificationId, final String... filter) {
		return notificationOperations.getMemberCreatorByNotification(notificationId, filter);
	}

	@Override
	public Member getOrganizationCreatorByNotification(String notificationId, final String... filter) {
		return notificationOperations.getOrganizationCreatorByNotification(notificationId, filter);
	}

	@Override
	public List<Action> getActionsByList(String listId) {
		return listOperationsDelegate.getActionsByList(listId);
	}

	@Override
	public Board getBoardByList(String listId, final String... filter) {
		return listOperationsDelegate.getBoardByList(listId, filter);
	}

	@Override
	public List<Card> getCardsByList(String listId, final String... filter) {
		return listOperationsDelegate.getCardsByList(listId, filter);
	}

	@Override
	public List<Action> getActionsByMember(String usernameOrId) {
		return memberOperations.getActionsByMember(usernameOrId);
	}

	@Override
	public List<Card> getCardsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getCardsByMember(usernameOrId, filter);
	}

	@Override
	public List<Notification> getNotificationsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getNotificationsByMember(usernameOrId, filter);
	}

	@Override
	public List<Organization> getOrganizationsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getOrganizationsByMember(usernameOrId, filter);
	}

	@Override
	public List<Organization> getOrganizationsInvitedByMember(String usernameOrId, final String... filter) {
		return memberOperations.getOrganizationsInvitedByMember(usernameOrId, filter);
	}

	@Override
	public Board getBoardByChecklist(String checklistId, final String... filter) {
		return checklistOperations.getBoardByChecklist(checklistId, filter);
	}

	@Override
	public List<CheckItem> getCheckItemsByChecklist(String checklistId) {
		return checklistOperations.getCheckItemsByChecklist(checklistId);
	}

	@Override
	public List<Card> getCardByChecklist(String checklistId, final String... filter) {
		return getCardByChecklist(checklistId, filter);
	}

	@Override
	public Token getToken(String tokenId, final String... filter) {
		return tokenOperations.getToken(tokenId, filter);
	}

	@Override
	public Member getMemberByToken(String tokenId, final String... filter) {
		return tokenOperations.getMemberByToken(tokenId, filter);
	}

	private InputStream doGet(String url) {
		return doRequest(url, METHOD_GET);
	}

	private InputStream doPut(String url) {
		return doRequest(url, METHOD_PUT);
	}

	private InputStream doPost(String url, Map<String, Object> map) {
		return doRequest(url, METHOD_POST, map).getInputStream();
	}

	private Response doPostWithResponse(String url, Map<String, Object> map) {
		return doRequest(url, METHOD_POST, map);
	}

	private Response doDelete(String url) {
		return doRequest(url, METHOD_DELETE, null);
	}

	private InputStream doRequest(String url, String requestMethod) {
		final Response response = doRequest(url, requestMethod, null);
		return response != null ? response.getInputStream() : null;
	}

	/**
	 * Execute a POST request with URL-encoded key-value parameter pairs. For a
	 * POST having an attachment, multipart/form-data will be used.
	 * 
	 * @param url
	 *            Trello API URL.
	 * @param map
	 *            Key-value map.
	 * @return the response input stream.
	 */
	private Response doRequest(String url, String requestMethod, Map<String, Object> map) {
		try {
			HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setDoOutput(requestMethod.equals(METHOD_POST) || requestMethod.equals(METHOD_PUT));
			conn.setRequestMethod(requestMethod);

			if (map != null && !map.isEmpty()) {
				boolean bAllStringValues = true;
				for (Object value : map.values()) {
					if (!(value instanceof String))
						bAllStringValues = false;
				}

				if (bAllStringValues) {
					StringBuilder sb = new StringBuilder();
					for (String key : map.keySet()) {
						sb.append(sb.length() > 0 ? "&" : "").append(key).append("=").append(URLEncoder.encode((String) map.get(key), "UTF-8"));
					}
					conn.getOutputStream().write(sb.toString().getBytes());
					conn.getOutputStream().close();
				} else {
					// write multipart.
					final String boundary = UUID.randomUUID().toString();
					conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

					final DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());

					String[] keys = map.keySet().toArray(new String[map.keySet().size()]);
					for (int i = 0; i < keys.length; i++) {
						String key = keys[i];
						if (map.get(key) instanceof File) {
							dataOutputStream.writeBytes(format("--%s\r\n", boundary));
							dataOutputStream.writeBytes(format("content-type: %s\r\n", "application/octet-stream"));
							dataOutputStream.writeBytes(format("Content-Disposition: form-data; name=\"%s\";filename=\"%s\"\r\n", key, ((File) map.get(key)).getName()));
							dataOutputStream.writeBytes("\r\n");

							FileInputStream fileInputStream = new FileInputStream((File) map.get(key));
							int bytesAvailable = fileInputStream.available();
							int maxBufferSize = 16384;
							int bufferSize = Math.min(maxBufferSize, bytesAvailable);

							byte[] buffer = new byte[bufferSize];

							int bytesRead = fileInputStream.read(buffer, 0, bufferSize);

							while (bytesRead > 0) {
								dataOutputStream.write(buffer, 0, bufferSize);
								bytesAvailable = fileInputStream.available();
								bufferSize = Math.min(bytesAvailable, maxBufferSize);
								bytesRead = fileInputStream.read(buffer, 0, bufferSize);
							}

							dataOutputStream.writeBytes("\r\n");
						} else {
							dataOutputStream.writeBytes(format("Content-Disposition: form-data; name=\"%s\"\r\n\r\n", key));
							dataOutputStream.writeBytes(format("%s\r\n\r\n", map.get(key)));
						}
						dataOutputStream.writeBytes(format("--%s%s\r\n", boundary, i == keys.length - 1 ? "--" : ""));
					}
				}
			}

			final int responseCode = conn.getResponseCode();
			if (responseCode == 404) {
				return null;
			} else if (responseCode > 399) {
				return new Response(conn.getErrorStream(), conn.getResponseMessage(), responseCode);
			} else {
				return new Response(getWrappedInputStream(conn.getInputStream(), GZIP_ENCODING.equalsIgnoreCase(conn.getContentEncoding())), conn.getResponseMessage(), responseCode);
			}
		} catch (IOException e) {
			throw new TrelloException(e.getMessage());
		}
	}

	private void validateObjectId(String id) {
		if (!TrelloUtil.isObjectIdValid(id)) {
			throw new TrelloException("Invalid object id: " + id);
		}
	}

	private InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
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

	@Override
	public Action getAction(String actionId, String... filter) {
		return actionOperationsDelegate.getAction(actionId, filter);
	}

	@Override
	public Board getBoardByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getBoardByAction(actionId, filter);
	}

	@Override
	public Card getCardByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getCardByAction(actionId, filter);
	}

	@Override
	public Member getMemberByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getMemberByAction(actionId, filter);
	}

	@Override
	public Member getMemberCreatorByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getMemberCreatorByAction(actionId, filter);
	}

	@Override
	public Organization getOrganizationByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getOrganizationByAction(actionId, filter);
	}

	@Override
	public org.trello4j.model.List getListByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getListByAction(actionId, filter);
	}

	@Override
	public Organization getOrganization(String organizationNameOrId, String... filter) {
		return organizationOperationsDelegate.getOrganization(organizationNameOrId, filter);
	}

	@Override
	public List<Board> getBoardsByOrganization(String organizationNameOrId, String... filter) {
		return organizationOperationsDelegate.getBoardsByOrganization(organizationNameOrId, filter);
	}

	@Override
	public List<Action> getActionsByOrganization(String organizationNameOrId) {
		return organizationOperationsDelegate.getActionsByOrganization(organizationNameOrId);
	}

	@Override
	public List<Member> getMembersByOrganization(String organizationNameOrId, String... filter) {
		return organizationOperationsDelegate.getMembersByOrganization(organizationNameOrId, filter);
	}

}
