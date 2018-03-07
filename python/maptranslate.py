#!/usr/bin/env python

from string import Template

html = '''<html>
<head>%(title)s</head>
<body>
<h1>%(title)s</h1>
<p>%(content)s</p>
</body>
</html>'''

mapp = {'title':'hongyangliao','content':'this is a content'}

print(html % mapp + '\n')

htm = '''<html>
<head>${title}</head>
<body>
<h1>${title}</h1>
<p>${content}</p>
</body>
</html>'''

tem = Template(htm)

print(tem.substitute(mapp) + '\n')
