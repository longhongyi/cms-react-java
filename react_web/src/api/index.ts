export const signIn= (value:any)=>{
    return fetch('/api/user/login',{
        method:'POST',
        headers:{
            'Content-Type': 'application/json; charset=UTF-8'
        },
        body:JSON.stringify(value)
    }).then(result=>{
        return result.json();
    }).then(data=>{
        return data;
    });
}

export const register=(value:any)=>{
    fetch('/api/user/register',{
        method:'POST',
        headers:{
            'Content-Type': 'application/json; charset=UTF-8'
        },
        body:JSON.stringify(value)
    }).then(result=>{
        result.json();
    }).then(data=>{
        return data;
    });
}