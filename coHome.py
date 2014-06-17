import cgi
import webapp2
import urllib
import facebook
import urlparse

FACEBOOK_APP_ID = "250827445119511"
FACEBOOK_APP_SECRET = "a2d124f9892d000aadbb0d83925251c6"

MAIN_PAGE_WEB = """\

<html>
  <body>
	<div><p><b>Questa App posta gli annunci di case disponibili per una possibile condivisione!!!</b></p></div>
  </body>
</html>
"""

#Questa classe va in esecuzione quando l'app è richiamata dall'icona di facebook
class MainPage(webapp2.RequestHandler):

    def get(self):
    	self.response.write(MAIN_PAGE_WEB)	        
        #self.response.write("<div><p>sono nella get</p></div>")
        
        verification_code = self.request.get("code")
	args = dict(client_id=FACEBOOK_APP_ID,redirect_uri=self.request.path_url)
	if self.request.get("code"):
		args["client_secret"] = FACEBOOK_APP_SECRET
	        args["code"] = self.request.get("code")
	        response = cgi.parse_qs(urllib.urlopen("https://graph.facebook.com/oauth/access_token?" + urllib.urlencode(args)).read())
            	access_token = response["access_token"][-1]
            	
               	#self.response.write("<div><p>sono nell if</p></div>")
              	#self.response.out.write("<div><p>access token: " + access_token + "</p></div>" )
              	
        	facebook_graph = facebook.GraphAPI(access_token)
		#self.response.out.write("<div><p>graphAPI ha un riferimento all access token</p></div>")
        	
        	# Try to post something on the wall.
		try:
			fb_response = facebook_graph.put_wall_post('Questa App posta gli annunci di case disponibili per una possibile condivisione...')
			#self.response.out.write("<div><p>no eccezione</p></div>")
		except facebook.GraphAPIError as e:
			self.response.out.write(e)
		#self.response.out.write("<div><p>fine!!!</p></div>")
		
        else:
        	#self.response.write("<div><p>sono nell else</p></div>")
                args = dict(client_id=FACEBOOK_APP_ID, redirect_uri=self.request.path_url)
                self.redirect("https://graph.facebook.com/oauth/authorize?" + urllib.urlencode(args))  
                #self.response.out.write("<div><p>fine else</p></div>")


    def post(self):
        args = dict(client_id=FACEBOOK_APP_ID, redirect_uri=self.request.path_url)
        self.redirect("https://graph.facebook.com/oauth/authorize?" + urllib.urlencode(args))
        
        
#Questa classe posta gli annunci di disponibilita' di case su facebook        
class CohomePost(webapp2.RequestHandler):

    def post(self):
    	access_token = self.request.get("access_token")
    	chiave1 = self.request.get("chiave1")
    	chiave2 = self.request.get("chiave2")
    	chiave = chiave1 + chiave2 + ',,,,'
    	facebook_graph = facebook.GraphAPI(access_token)
    	
    	# Try to post something on the wall.
	try:
		#posta due messaggi
		fb_response = facebook_graph.put_wall_post('Hello from Java ,GoogleApp and Python.....')
		fb_response = facebook_graph.put_wall_post(chiave)
	except facebook.GraphAPIError as e:
		self.response.out.write(e)

           

application = webapp2.WSGIApplication([
    ('/', MainPage),
    ('/web', CohomePost),
], debug=True)