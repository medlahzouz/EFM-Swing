package Hibernate_util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DoubleValidate extends PlainDocument {

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		try {
			String firstText = this.getText(0, offs);
			String texte = firstText + str + this.getText(offs, this.getLength() - firstText.length());
			Double.parseDouble(texte);
			super.insertString(offs, str, a);
		} catch (Exception e) {
			return;
		}
	}
}
