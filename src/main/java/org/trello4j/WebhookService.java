package org.trello4j;

import java.util.List;
import java.util.Map;

import org.trello4j.model.Webhook;

/**
 * The Interface WebhookService.
 * 
 * @author 
 */
public interface WebhookService {
	List<Webhook> getWebhooks();

	Webhook createWebhook(String description, String callbackUrl, String idModel);
	
	void deleteWebhook(String idWebhook);
	
	Webhook getWebhook(String idWebhook);
}
