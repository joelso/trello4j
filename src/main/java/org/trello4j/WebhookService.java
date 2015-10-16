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
	Webhook getWebhook(String webhookId);

	Webhook createWebhook(String description, String callbackUrl);
}
