package ie.sortons.gwtfbplus.shared.domain.fql;


import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gwt.core.shared.GwtIncompatible;


/*
{ "data": [
      {
         "post_id": "139957459378369_128060617343105",
         "actor_id": 600747004,
         "target_id": 139957459378369,
         "message": "Deal going over this weekend only. perfect for all at UCD\nhttp://dublin.ratemyarea.com/deals/490",
         "attachment": {
            "media": [
               {
                  "href": "http://dublin.ratemyarea.com/deals/490",
                  "alt": "",
                  "type": "link",
                  "src": "http://external.ak.fbcdn.net/safe_image.php?d=AQBM_0OZq_De_NEG&w=90&h=90&url=http\u00253A\u00252F\u00252Fimages.ratemyarea.com.s3.amazonaws.com\u00252Fassets\u00252F0295\u00252F6894\u00252Fsubway_large_thumb.png\u00253Fpicture\u00253D2956894"
               }
            ]
         }
      }, 
      
      
      or
      
      
      
      {
    "error": {
        "message": "An unexpected error has occurred. Please retry your request later.",
        "type": "OAuthException",
        "code": 2
    }
}
 */



public class FqlStream {

	FqlStream() {}

		/*	

	    	{
	         "post_id": "139957459378369_128060617343105",
	         "actor_id": 600747004,
	         "target_id": 139957459378369,
	         "message": "Deal going over this weekend only. perfect for all at UCD\nhttp://dublin.ratemyarea.com/deals/490",
	         "attachment": {
	            "media": [
	               {
	                  "href": "http://dublin.ratemyarea.com/deals/490",
	                  "alt": "",
	                  "type": "link",
	                  "src": "http://external.ak.fbcdn.net/safe_image.php?d=AQBM_0OZq_De_NEG&w=90&h=90&url=http\u00253A\u00252F\u00252Fimages.ratemyarea.com.s3.amazonaws.com\u00252Fassets\u00252F0295\u00252F6894\u00252Fsubway_large_thumb.png\u00253Fpicture\u00253D2956894"
	               }
	            ]
	         }
	    	}
		 */
		
		public Long getSourceId() {
			return source_id;
		}


		public String getPostId() {
			return post_id;
		}


		public Long getActorId() {
			return actor_id;
		}


		public Long getTargetId() {
			return target_id;
		}


		public String getMessage() {
			return message;
		}


		public String getPermalink() {
			return permalink;
		}

		public Integer getCreatedTime() {
			return created_time;
		}


		public FqlStreamItemAttachment getAttachment() {
			return attachment;
		}

		
		private Long actor_id;
		private String message;

		private String post_id;
		private Long source_id;
		
		private Long target_id;
		
		private String permalink;

		private Integer created_time;
		
		private FqlStreamItemAttachment attachment;


		@GwtIncompatible
		public static class FqlStreamItemAttachmentAdapter implements JsonDeserializer<FqlStreamItemAttachment> {

			@Override
			public FqlStreamItemAttachment deserialize(JsonElement json, Type type, JsonDeserializationContext context) 
					throws JsonParseException {

				FqlStreamItemAttachment attachment = null;

				// I think the term to describe this is "polymorphic"
				if (json.isJsonArray()) {

					attachment = null;

				} else if (json.isJsonObject()) {

					// TODO: this is done wrong.
					// It should be something like:
					// attachment = (FqlStreamItemAttachment) context.deserialize(json, FqlStreamItemAttachment.class);
					// but that has this Adapter attached so it recurses inside here and Internal Server Error occurs.
					// I'm not sure how to actually use the FqlStreamItemAttachment class in here without starting a new Gson object

					Gson gson = new Gson();
					attachment = (FqlStreamItemAttachment) gson.fromJson(json, FqlStreamItemAttachment.class);

				} else {
					throw new RuntimeException("Unexpected JSON type: " + json.getClass());
				}
				return attachment;

			}

		}




	public static class FqlStreamItemAttachment {

		public FqlStreamItemAttachmentMediaItem[] getMedia() {
			return media;
		}

		private FqlStreamItemAttachmentMediaItem[] media; 

		FqlStreamItemAttachment() {}

	}

	public static class FqlStreamItemAttachmentMediaItem {

		public String getHref() {
			return href;
		}

		public String getAlt() {
			return alt;
		}

		public String getType() {
			return type;
		}

		public String getSrc() {
			return src;
		}

		public FqlStreamItemAttachmentMediaItemPhoto getPhoto() {
			return photo;
		}

		FqlStreamItemAttachmentMediaItem() {}

		private String href;
		private String alt;
		private String type;
		private String src;

		private FqlStreamItemAttachmentMediaItemPhoto photo;

	}



	public static class FqlStreamItemAttachmentMediaItemPhoto {

		public String getAid() {
			return aid;
		}

		public String getPid() {
			return pid;
		}

		public Long getFbid() {
			return fbid;
		}

		public Long getOwner() {
			return owner;
		}

		public Integer getIndex() {
			return index;
		}

		public Integer getWidth() {
			return width;
		}

		public Integer getHeight() {
			return height;
		}

		public FqlStreamItemAttachmentMediaItemPhotoImage[] getImages() {
			return images;
		}

		FqlStreamItemAttachmentMediaItemPhoto() {}

		private String aid;
		private String pid;
		private Long fbid;
		private Long owner;
		private Integer index;
		private Integer width;
		private Integer height;

		public FqlStreamItemAttachmentMediaItemPhotoImage[] images;

	}




	public static class FqlStreamItemAttachmentMediaItemPhotoImage {

		public String getSrc() {
			return src;
		}
		public String getWidth() {
			return width;
		}
		public String getHeight() {
			return height;
		}
		FqlStreamItemAttachmentMediaItemPhotoImage() {}

		private String src;
		private String width;
		private String height;

	}
}
