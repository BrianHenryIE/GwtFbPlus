package ie.sortons.gwtfbplus.shared.domain.graph;

import ie.sortons.gwtfbplus.shared.domain.FbError;

import java.util.ArrayList;
import java.util.Date;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class GraphUser implements JsonSerializable {

	/**
	 * @return The id of this person's user account.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return The person's full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The person's first name
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * @return The person's last name.
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * @return A link to the person's profile.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @return This person's birthday in the format MM/DD/YYYY.
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @return The person's hometown
	 */
	public GraphPage getHometown() {
		return hometown;
	}

	/**
	 * @return The person's current location as entered by them on their profile. This is not a check in field.
	 */
	public GraphPage getLocation() {
		return location;
	}

	/**
	 * @return The 'about me' section of this person's profile.
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @return The person's favorite quotes
	 */
	public String getQuotes() {
		return quotes;
	}

	/**
	 * @return The periods of a person's employment history.
	 */
	public ArrayList<Work> getWork() {
		return work;
	}

	/**
	 * @return The sections of a person's education history.
	 */
	public ArrayList<Education> getEducation() {
		return education;
	}

	/**
	 * @return The person's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return The person's religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @return The person's political views
	 */
	public String getPolitical() {
		return political;
	}

	/**
	 * @return This person's primary email address listed on their profile.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return The person's website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @return The person's locale.
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @return Facebook Pages representing the languages this person knows.
	 */
	public ArrayList<GraphPage> getLanguages() {
		return languages;
	}

	/**
	 * This is distinct from the is_verified field. Someone is considered verified if they take any of the following
	 * actions: Register for mobile Confirm their account via SMS Enter a valid credit card
	 * 
	 * @return Indicates whether the user account has been verified.
	 */
	public boolean getVerified() {
		return verified;
	}

	/**
	 * @return the updated_time
	 */
	public Date getUpdatedTime() {
		return updated_time;
	}

	/**
	 * @return The person's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the error
	 */
	public FbError getError() {
		return error;
	}

	public Long id;
	public String name;
	public String first_name;
	public String last_name;
	public String link;
	public String birthday;
	public GraphPage hometown;
	public GraphPage location;
	public String bio;
	public String quotes;
	public ArrayList<Work> work;

	public static class Work implements JsonSerializable {
		/**
		 * @return The Facebook Page that represents the employer in this period.
		 */
		public GraphPage getEmployer() {
			return employer;
		}
		/**
		 * @return The Facebook Page representing the location of this employment.
		 */
		public GraphPage getLocation() {
			return location;
		}
		/**
		 * @return The Facebook Page that represents the position that was held.
		 */
		public GraphPage getPosition() {
			return position;
		}
		/**
		 * @return When the employment period started.
		 */
		public Date getStartDate() {
			return start_date;
		}
		/**
		 * @return When the employment period ended. Not returned if employment is still current.
		 */
		public Date getEndDate() {
			return end_date;
		}
		/**
		 * @return Each of the projects this person was involved in during this employment period.
		 */
		public ArrayList<Project> getProjects() {
			return projects;
		}
		public GraphPage employer;
		public GraphPage location;
		public GraphPage position;
		public Date start_date;
		public Date end_date;
		public ArrayList<Project> projects;

	}

	public static class Project implements JsonSerializable {
		/**
		 * @return A list of people involved with this project.
		 */
		public ArrayList<GraphUser> getWith() {
			return with;
		}
		/**
		 * @return The description given to this project.
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * @return When the project started.
		 */
		public Date getStart_date() {
			return start_date;
		}
		/**
		 * @return When the project ended. Not returned if project is still ongoing.
		 */
		public Date getEnd_date() {
			return end_date;
		}
		public ArrayList<GraphUser> with;
		public String description;
		public Date start_date;
		public Date end_date;
	}

	public ArrayList<Education> education;

	public static class Education implements JsonSerializable {
		/**
		 * @return The Facebook Page that represents a school in this section.
		 */
		public GraphPage getSchool() {
			return school;
		}
		/**
		 * @return The Facebook Page that represents the year of graduation in this section.
		 */
		public GraphPage getYear() {
			return year;
		}
		/**
		 * @return Facebook Pages representing the subjects studied in this section.
		 */
		public ArrayList<GraphPage> getConcentration() {
			return concentration;
		}
		/**
		 * @return Indicates the type of educational institution.
		 */
		public String getType() {
			return type;
		}
		public GraphPage school;
		public GraphPage year;
		public ArrayList<GraphPage> concentration;
		public String type;
	}

	public String gender;
	public String religion;
	public String political;
	public String email;
	public String website;

	public String locale;

	public ArrayList<GraphPage> languages;

	public boolean verified;
	public Date updated_time;
	public String username;

	public FbError error;

}
