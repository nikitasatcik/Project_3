<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template  match="/">
        <html>
            <head>list</head>
            <body>
                <h1>Weapon List</h1>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Model</th>
                        <th>Handy</th>
                        <th>Origin</th>
                        <th>maxRange</th>
                        <th>deadRange</th>
                        <th>Magazine</th>
                        <th>Optics</th>
                    </tr>
                    <xsl:for-each select="weapon/gun">
                        <tr>
                            <td><xsl:value-of select="@name"/></td>
                            <td><xsl:value-of select="model/@serialModel"/></td>
                            <td><xsl:value-of select="handy"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="ttc/range/@maxRange"/></td>
                            <td><xsl:value-of select="ttc/range/@deadRange"/></td>
                            <td>
                                <xsl:choose>
                                    <xsl:when test="ttc/magazine='true'">
                                        <xsl:text>yes</xsl:text>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <xsl:text>no</xsl:text>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                            <td>
                                <xsl:choose>
                                    <xsl:when test="ttc/optic='true'">
                                        <xsl:text>yes</xsl:text>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <xsl:text>no</xsl:text>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
