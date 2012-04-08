## Introduction
**trello4j** is a java wrapper around [Trello API](https://trello.com/docs/api/index.html).

You need to get a API key, and optionally generate a token, [here](https://trello.com/1/appKey/generate) to be able to use Trello's API.

## Getting started
Get source and build it:

    git clone git@github.com:joelso/trello4j.git
	cd trello4j
	mvn install

Now you got two options:

1. Use trello4j from your local maven repo, add dependency groupId: org.trello4j / artifactId: trello4j
2. Use jar that was built in directory **target/**

## Usage

   Trello trello = new TrelloImpl("myApiKey", "myToken");  // myToken is optional, set to null if you are accessing public data
   List<Organization> = trello.getOrganization("fogcreek");	// just an 


## Roadmap

* 1.0 - *core* read-only API methods
* 1.1 - fully support all read-only methods (i.e. all GET methods)
* 2.0 - support create and update 

<table>
  <tr><th>Method</th><th>Version</th></tr>
  
  <tr><td>GET /1/actions/[action_id]</td><td>1.0</td>                        </tr>
  <tr><td>GET /1/actions/[action_id]/[field]</td><td>1.1</td>              </tr>  
  <tr><td>GET /1/actions/[action_id]/board</td><td>1.1</td>                </tr>  
  <tr><td>GET /1/actions/[action_id]/board/[field]</td><td>1.1</td>        </tr>  
  <tr><td>GET /1/actions/[action_id]/card</td><td>1.1</td>                 </tr>  
  <tr><td>GET /1/actions/[action_id]/card/[field]</td><td>1.1</td>         </tr>  
  <tr><td>GET /1/actions/[action_id]/list</td><td>1.1</td>                 </tr>  
  <tr><td>GET /1/actions/[action_id]/list/[field]</td><td>1.1</td>         </tr>  
  <tr><td>GET /1/actions/[action_id]/member</td><td>1.1</td>               </tr>  
  <tr><td>GET /1/actions/[action_id]/member/[field]</td><td>1.1</td>       </tr>  
  <tr><td>GET /1/actions/[action_id]/memberCreator</td><td>1.1</td>        </tr>  
  <tr><td>GET /1/actions/[action_id]/memberCreator/[field]</td><td>1.1</td></tr>  
  <tr><td>GET /1/actions/[action_id]/organization</td><td>1.1</td>         </tr>  
  <tr><td>GET /1/actions/[action_id]/organization/[field]</td><td>1.1</td> </tr>  
</table>




	

	
	






