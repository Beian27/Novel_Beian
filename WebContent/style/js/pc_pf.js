var pc_ab_key = 'k24';
var hf_url="/ab_res/pc/pf";

document.writeln('<script src="/ab_res/pc/pf/pf.js?ab_key=k24"></script>');

// list/content
url = window.location.toString();
if (url.match(/\/files\/article\/html\/\d+\/(\d+)\/index\.html/) || url.match(/\/files\/article\/html\/\d+\/(\d+)\//) || url.match(/\/files\/article\/html\/\d+\/(\d+)\/(\d+)\.html/)){
    document.writeln('<script src="/ab_res/pc/pop.js?ab_key=k24" language="JavaScript"></script>');
}