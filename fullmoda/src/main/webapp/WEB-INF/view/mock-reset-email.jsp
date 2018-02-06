<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'/>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 30px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<p>From: ${mail.getFrom()}</p>
<p>To: ${mail.getTo()}</p>
<p>Subject: ${mail.getSubject()}</p>
<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#78ab46" style="padding: 40px 0 30px 0;">
            <p>Fullmoda.it</p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
            <p>Dear ${mail.getModel().get("user").name} ${mail.getModel().get("user").surname}</p>
            <p>
                Hai richesto il ripristino della password.
                <a href="${mail.getModel().get('resetUrl')}">Ripristina la tua password</a>
            </p>
            <p>Thanks</p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#777777" style="padding: 30px 30px 30px 30px;">
            <p> ${mail.getModel().get("signature")}</p>
        </td>
    </tr>
</table>

</body>
</html>