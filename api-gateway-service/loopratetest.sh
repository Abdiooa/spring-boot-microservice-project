#!/bin/bash
REQUESTS=100
ACCESS_TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJEdVNVZkQ2emw2WVd5bjUzZHNSWURxS0Y1WVlRSndjN3c3TWNPOXA0MExBIn0.eyJleHAiOjE2OTMyMjM0MDAsImlhdCI6MTY5MzIyMzEwMCwianRpIjoiMWQzNDM3MWItOWYwNi00Zjc1LTkzZDQtNGYwZTkwNmVkZmU0IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgwL3JlYWxtcy9taWNyby1yZWFsbS1ieS1tZSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJmOTdjNDIzYi1hNTAxLTQ1ODgtYmQ2Yy1lZWU1ODY4ZDYzMDgiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJtaWNyby1hdXRoLWJ5LW1lIiwic2Vzc2lvbl9zdGF0ZSI6Ijg0MWExOGVhLWVhOTgtNDQwMi05YzJlLWJiZjhmOGNhZmU5ZSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDo5MTkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW1pY3JvLXJlYWxtLWJ5LW1lIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im1pY3JvLWF1dGgtYnktbWUiOnsicm9sZXMiOlsiYWRtaW4iXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwiLCJzaWQiOiI4NDFhMThlYS1lYTk4LTQ0MDItOWMyZS1iYmY4ZjhjYWZlOWUiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IkFiZGkgT21hciIsInByZWZlcnJlZF91c2VybmFtZSI6ImFiZGkiLCJnaXZlbl9uYW1lIjoiQWJkaSIsImZhbWlseV9uYW1lIjoiT21hciIsImVtYWlsIjoiYWJkaW9vYTQ1QGdtYWlsLmNvbSJ9.RL5umm4ok0hQxt6KEROysA1CJGQKi4cgq-CV1Wun7IvSrYT4aNuxGbOA724HvgN1eFL9yPYXxYoiGnKKtjDpAzSecH8fHzCpsCd5DmUbH4lJ8RaS0_8n8RjYAcTtqc1GPnZD7VniLG1rOekQ7mDKHpcHvvpsG-HLpOAJPOkE07ijSy4Ox9Tbbas-ZERoX5jx0kU2tBtaHHyax1ebWCLOJFG9zMIz-DpbdKt-cagIP7ZLf-BOrpalwDN48PaaujzGdza8yOq211cMowKEjFS_UaQpAI5uDhY1Cpam6dwmIw0ToIzz973syl6e1fsnWaQ0FErYtgwFSHwdKvoGf5QuhA"
for ((i = 1; i <= REQUESTS; i++))
do
  curl -s -o /dev/null -I -w "%{http_code}" -X GET http://localhost:9191/api/products -H "Authorization: Bearer $ACCESS_TOKEN"
  echo ""
done