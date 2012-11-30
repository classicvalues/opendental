package com.opendental.odweb.client.tabletypes;

import com.google.gwt.xml.client.Document;
import com.opendental.odweb.client.remoting.Serializing;

public class TaskUnread {
		/** Primary key. */
		public int TaskUnreadNum;
		/** FK to task.TaskNum. */
		public int TaskNum;
		/** FK to userod.UserNum. */
		public int UserNum;

		/** Deep copy of object. */
		public TaskUnread Copy() {
			TaskUnread taskunread=new TaskUnread();
			taskunread.TaskUnreadNum=this.TaskUnreadNum;
			taskunread.TaskNum=this.TaskNum;
			taskunread.UserNum=this.UserNum;
			return taskunread;
		}

		/** Serialize the object into XML. */
		public String SerializeToXml() {
			StringBuilder sb=new StringBuilder();
			sb.append("<TaskUnread>");
			sb.append("<TaskUnreadNum>").append(TaskUnreadNum).append("</TaskUnreadNum>");
			sb.append("<TaskNum>").append(TaskNum).append("</TaskNum>");
			sb.append("<UserNum>").append(UserNum).append("</UserNum>");
			sb.append("</TaskUnread>");
			return sb.toString();
		}

		/** Sets all the variables on this object based on the values in the XML document.  Variables that are not in the XML document will be null or their default values.
		 * @param doc A parsed XML document.  Must be valid XML.  Does not need to contain a node for every variable on this object.
		 * @throws Exception DeserializeFromXml is entirely encased in a try catch and will throw exceptions if anything goes wrong. */
		public void DeserializeFromXml(Document doc) throws Exception {
			try {
				if(Serializing.GetXmlNodeValue(doc,"TaskUnreadNum")!=null) {
					TaskUnreadNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"TaskUnreadNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"TaskNum")!=null) {
					TaskNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"TaskNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"UserNum")!=null) {
					UserNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"UserNum"));
				}
			}
			catch(Exception e) {
				throw e;
			}
		}


}