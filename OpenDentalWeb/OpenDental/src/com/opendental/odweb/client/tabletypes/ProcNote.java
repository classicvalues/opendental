package com.opendental.odweb.client.tabletypes;

import com.google.gwt.xml.client.Document;
import com.opendental.odweb.client.remoting.Serializing;
import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;

public class ProcNote {
		/** Primary key. */
		public int ProcNoteNum;
		/** FK to patient.PatNum */
		public int PatNum;
		/** FK to procedurelog.ProcNum */
		public int ProcNum;
		/** The server time that this note was entered. Essentially a timestamp. */
		public Date EntryDateTime;
		/** FK to userod.UserNum. */
		public int UserNum;
		/** The actual note. */
		public String Note;
		/** There are two kinds of signatures.  Topaz signatures use hardware manufactured by that company, and the signature is created by their library.  OD signatures work exactly the same way, but are only for on-screen signing. */
		public boolean SigIsTopaz;
		/** The encrypted signature.  A signature starts as a collection of vectors.  The Topaz .sig file format is proprietary.  The OD signature format looks like this: 45,68;48,70;49,72;0,0;55,88;etc.  It's simply a sequence of points, separated by semicolons.  0,0 represents pen up.  Then, a hash is created from the Note, concatenated directly with the userNum.  For example, "This is a note3" gets turned into a hash of 2849283940385391 (16 bytes).  The hash is used to encrypt the signature data string using symmetric encryption.  Therefore, the actual signature cannot be retrieved from the database by ordinary means.  Also, the signature info cannot even be retrieved by Open Dental at all unless it supplies the same hash as before, proving that the data has not changed since signed.  If OD supplies the correct hash, then it will be able to extract the sequence of vectors which it will then use to display the signature.  The OD sigs are not compressed, and the Topaz sigs are.  But there is very little difference in their sizes.  It would be very rare for a signature to be larger than 1000 bytes. */
		public String Signature;

		/** Deep copy of object. */
		public ProcNote Copy() {
			ProcNote procnote=new ProcNote();
			procnote.ProcNoteNum=this.ProcNoteNum;
			procnote.PatNum=this.PatNum;
			procnote.ProcNum=this.ProcNum;
			procnote.EntryDateTime=this.EntryDateTime;
			procnote.UserNum=this.UserNum;
			procnote.Note=this.Note;
			procnote.SigIsTopaz=this.SigIsTopaz;
			procnote.Signature=this.Signature;
			return procnote;
		}

		/** Serialize the object into XML. */
		public String SerializeToXml() {
			StringBuilder sb=new StringBuilder();
			sb.append("<ProcNote>");
			sb.append("<ProcNoteNum>").append(ProcNoteNum).append("</ProcNoteNum>");
			sb.append("<PatNum>").append(PatNum).append("</PatNum>");
			sb.append("<ProcNum>").append(ProcNum).append("</ProcNum>");
			sb.append("<EntryDateTime>").append(DateTimeFormat.getFormat("yyyyMMddHHmmss").format(EntryDateTime)).append("</EntryDateTime>");
			sb.append("<UserNum>").append(UserNum).append("</UserNum>");
			sb.append("<Note>").append(Serializing.EscapeForXml(Note)).append("</Note>");
			sb.append("<SigIsTopaz>").append((SigIsTopaz)?1:0).append("</SigIsTopaz>");
			sb.append("<Signature>").append(Serializing.EscapeForXml(Signature)).append("</Signature>");
			sb.append("</ProcNote>");
			return sb.toString();
		}

		/** Sets all the variables on this object based on the values in the XML document.  Variables that are not in the XML document will be null or their default values.
		 * @param doc A parsed XML document.  Must be valid XML.  Does not need to contain a node for every variable on this object.
		 * @throws Exception DeserializeFromXml is entirely encased in a try catch and will throw exceptions if anything goes wrong. */
		public void DeserializeFromXml(Document doc) throws Exception {
			try {
				if(Serializing.GetXmlNodeValue(doc,"ProcNoteNum")!=null) {
					ProcNoteNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"ProcNoteNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"PatNum")!=null) {
					PatNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"PatNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"ProcNum")!=null) {
					ProcNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"ProcNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"EntryDateTime")!=null) {
					EntryDateTime=DateTimeFormat.getFormat("yyyyMMddHHmmss").parseStrict(Serializing.GetXmlNodeValue(doc,"EntryDateTime"));
				}
				if(Serializing.GetXmlNodeValue(doc,"UserNum")!=null) {
					UserNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"UserNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"Note")!=null) {
					Note=Serializing.GetXmlNodeValue(doc,"Note");
				}
				if(Serializing.GetXmlNodeValue(doc,"SigIsTopaz")!=null) {
					SigIsTopaz=(Serializing.GetXmlNodeValue(doc,"SigIsTopaz")=="0")?false:true;
				}
				if(Serializing.GetXmlNodeValue(doc,"Signature")!=null) {
					Signature=Serializing.GetXmlNodeValue(doc,"Signature");
				}
			}
			catch(Exception e) {
				throw e;
			}
		}


}