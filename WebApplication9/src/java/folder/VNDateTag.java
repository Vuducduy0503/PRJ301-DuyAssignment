/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package folder;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VNDateTag extends TagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date currentDate = new Date();
            String formattedDate = sdf.format(currentDate);
            pageContext.getOut().write(formattedDate);
        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}
