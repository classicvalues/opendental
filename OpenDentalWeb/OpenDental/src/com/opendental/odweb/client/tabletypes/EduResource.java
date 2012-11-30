package com.opendental.odweb.client.tabletypes;

import com.google.gwt.xml.client.Document;
import com.opendental.odweb.client.remoting.Serializing;

public class EduResource {
		/** Primary key. */
		public int EduResourceNum;
		/** FK to diseasedef.DiseaseDefNum.  */
		public int DiseaseDefNum;
		/** FK to medication.MedicationNum.  */
		public int MedicationNum;
		/** FK to labresult.TestID.  */
		public String LabResultID;
		/** Used for display in the grid. */
		public String LabResultName;
		/** String, example <43. Must start with < or > followed by int.  Only used if FK LabResultID is used. */
		public String LabResultCompare;
		/** . */
		public String ResourceUrl;
		/** FK to icd9.ICD9Num. */
		public int Icd9Num;

		/** Deep copy of object. */
		public EduResource Copy() {
			EduResource eduresource=new EduResource();
			eduresource.EduResourceNum=this.EduResourceNum;
			eduresource.DiseaseDefNum=this.DiseaseDefNum;
			eduresource.MedicationNum=this.MedicationNum;
			eduresource.LabResultID=this.LabResultID;
			eduresource.LabResultName=this.LabResultName;
			eduresource.LabResultCompare=this.LabResultCompare;
			eduresource.ResourceUrl=this.ResourceUrl;
			eduresource.Icd9Num=this.Icd9Num;
			return eduresource;
		}

		/** Serialize the object into XML. */
		public String SerializeToXml() {
			StringBuilder sb=new StringBuilder();
			sb.append("<EduResource>");
			sb.append("<EduResourceNum>").append(EduResourceNum).append("</EduResourceNum>");
			sb.append("<DiseaseDefNum>").append(DiseaseDefNum).append("</DiseaseDefNum>");
			sb.append("<MedicationNum>").append(MedicationNum).append("</MedicationNum>");
			sb.append("<LabResultID>").append(Serializing.EscapeForXml(LabResultID)).append("</LabResultID>");
			sb.append("<LabResultName>").append(Serializing.EscapeForXml(LabResultName)).append("</LabResultName>");
			sb.append("<LabResultCompare>").append(Serializing.EscapeForXml(LabResultCompare)).append("</LabResultCompare>");
			sb.append("<ResourceUrl>").append(Serializing.EscapeForXml(ResourceUrl)).append("</ResourceUrl>");
			sb.append("<Icd9Num>").append(Icd9Num).append("</Icd9Num>");
			sb.append("</EduResource>");
			return sb.toString();
		}

		/** Sets all the variables on this object based on the values in the XML document.  Variables that are not in the XML document will be null or their default values.
		 * @param doc A parsed XML document.  Must be valid XML.  Does not need to contain a node for every variable on this object.
		 * @throws Exception DeserializeFromXml is entirely encased in a try catch and will throw exceptions if anything goes wrong. */
		public void DeserializeFromXml(Document doc) throws Exception {
			try {
				if(Serializing.GetXmlNodeValue(doc,"EduResourceNum")!=null) {
					EduResourceNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"EduResourceNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"DiseaseDefNum")!=null) {
					DiseaseDefNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"DiseaseDefNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"MedicationNum")!=null) {
					MedicationNum=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"MedicationNum"));
				}
				if(Serializing.GetXmlNodeValue(doc,"LabResultID")!=null) {
					LabResultID=Serializing.GetXmlNodeValue(doc,"LabResultID");
				}
				if(Serializing.GetXmlNodeValue(doc,"LabResultName")!=null) {
					LabResultName=Serializing.GetXmlNodeValue(doc,"LabResultName");
				}
				if(Serializing.GetXmlNodeValue(doc,"LabResultCompare")!=null) {
					LabResultCompare=Serializing.GetXmlNodeValue(doc,"LabResultCompare");
				}
				if(Serializing.GetXmlNodeValue(doc,"ResourceUrl")!=null) {
					ResourceUrl=Serializing.GetXmlNodeValue(doc,"ResourceUrl");
				}
				if(Serializing.GetXmlNodeValue(doc,"Icd9Num")!=null) {
					Icd9Num=Integer.valueOf(Serializing.GetXmlNodeValue(doc,"Icd9Num"));
				}
			}
			catch(Exception e) {
				throw e;
			}
		}


}