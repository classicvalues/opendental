package com.opendental.odweb.client.tabletypes;

import com.google.gwt.xml.client.Document;
import com.opendental.odweb.client.remoting.Serializing;

public class SigButDefElement {
		/** Primary key. */
		public int ElementNum;
		/** FK to sigbutdef.SigButDefNum  A few elements are usually attached to a single button. */
		public int SigButDefNum;
		/** FK to sigelementdef.SigElementDefNum, which contains the actual sound or light. */
		public int SigElementDefNum;

		/** Deep copy of object. */
		public SigButDefElement Copy() {
			SigButDefElement sigbutdefelement=new SigButDefElement();
			sigbutdefelement.ElementNum=this.ElementNum;
			sigbutdefelement.SigButDefNum=this.SigButDefNum;
			sigbutdefelement.SigElementDefNum=this.SigElementDefNum;
			return sigbutdefelement;
		}

		/** Serialize the object into XML. */
		public String SerializeToXml() {
			StringBuilder sb=new StringBuilder();
			sb.append("<SigButDefElement>");
			sb.append("<ElementNum>").append(ElementNum).append("</ElementNum>");
			sb.append("<SigButDefNum>").append(SigButDefNum).append("</SigButDefNum>");
			sb.append("<SigElementDefNum>").append(SigElementDefNum).append("</SigElementDefNum>");
			sb.append("</SigButDefElement>");
			return sb.toString();
		}

		/** Sets all the variables on this object based on the values in the XML document.  Variables that are not in the XML document will be null or their default values.
		 * @param doc A parsed XML document.  Must be valid XML.  Does not need to contain a node for every variable on this object.
		 * @throws Exception DeserializeFromXml is entirely encased in a try catch and will throw exceptions if anything goes wrong. */
		public void DeserializeFromXml(Document doc) throws Exception {
			try {
				if(Serializing.GetXmlNodeValue(doc,"ElementNum")!=null) {
					ElementNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"ElementNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"SigButDefNum")!=null) {
					SigButDefNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"SigButDefNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"SigElementDefNum")!=null) {
					SigElementDefNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"SigElementDefNum"));
				}
			}
			catch(Exception e) {
				throw e;
			}
		}


}