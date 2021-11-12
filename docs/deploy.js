const { which, cd, exec, echo, exit } = require('shelljs')

if (!which('git')) {
  echo('Sorry, this script requires git')
  exit(1)
}

// build docs
exec('npm run build')

// navigate into the build output directory
cd('src/.vuepress/dist')

// if you are deploying to a custom domain
// echo(""'www.example.com' > CNAME")

exec("git init")
exec("git add -A")

if (exec('git commit -m "deploy"').code !== 0) {
  echo('Error: Git commit failed')
  exit(1)
}

// if you are deploying to https://<USERNAME>.github.io/<REPO>
exec('git push -f https://github.com/worldline/learning-kotlin.git main:gh-pages')

cd("-")