<template>
    <button> 
        <a href=""> <span>{{ label }}</span> </a>
    </button>
</template>

<script lang="ts" setup>
    const props =  defineProps({
        label: String,
        id: Number
    })

</script>

<style>

</style>